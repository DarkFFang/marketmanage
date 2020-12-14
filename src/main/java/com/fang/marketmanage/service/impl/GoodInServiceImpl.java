package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.GoodInMapper;
import com.fang.marketmanage.dao.StockMapper;
import com.fang.marketmanage.entity.GoodIn;
import com.fang.marketmanage.service.GoodInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 服务实现 {@code GoodInServiceImpl} 商品入库表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Slf4j
@Service
public class GoodInServiceImpl implements GoodInService {
    /**
     * 实例GoodInMapper
     */
    @Autowired
    private GoodInMapper goodInMapper;
    /**
     * 实例StockMapper
     */
    @Autowired
    private StockMapper stockMapper;

    /**
     * 添加新的入库表
     *
     * @param goodIn
     * @return int
     */
    @Override
    public int addNewGoodIn(GoodIn goodIn) {
        /**
         * 接收数据，修改库存表和增加商品入库表项
         */
        stockMapper.updateStockQuantityIncByGoodId(goodIn.getGoodId(), goodIn.getQuantity());
        goodIn.setDate(new Date());
        return goodInMapper.addNewGoodIn(goodIn);
    }

    /**
     * 商品入库列表
     *
     * @return {@link List<GoodIn>}
     */
    @Override
    public List<GoodIn> findGoodInList() {
        /**
         * 调用列表方法
         */
        return goodInMapper.findGoodInList();
    }

    /**
     * 删除商品表项
     *
     * @param id id
     * @return int
     */
    @Override
    public int deleteGoodInById(Integer id) {
        /**
         * 删除商品表项后，同步库存表数据
         */
        GoodIn goodIn = goodInMapper.findGoodInById(id);
        int result = goodInMapper.deleteGoodInById(id);
        if (result == 1) {
            stockMapper.updateStockQuantityDecByGoodId(goodIn.getGoodId(), goodIn.getQuantity());
            goodInMapper.alterGoodInAutoIncrement();
        }
        return result;
    }

    /**
     * 修改入库表项
     * @param goodIn
     * @return
     */
    @Override
    public int updateGoodInById(GoodIn goodIn) {
        /**
         * 修改入库表项后，同步库存表
         */
        log.warn(goodIn.toString());
        Integer oldQuantity = goodInMapper.findGoodInById(goodIn.getId()).getQuantity();
        int result = goodInMapper.updateGoodInById(goodIn);
        if (result == 1) {
            GoodIn newGoodIn = goodInMapper.findGoodInById(goodIn.getId());
            stockMapper.updateStockQuantityIncByGoodId(newGoodIn.getGoodId(), newGoodIn.getQuantity() - oldQuantity);
        }
        return result;
    }

    /**
     * 通过商品名称查找入库表
     * @param name
     * @return
     */
    @Override
    public List<GoodIn> findGoodInListByName(String name) {
        return null;
    }

    /**
     * 通过时间查找入库表
     * @param date
     * @return
     */
    @Override
    public List<GoodIn> findGoodInListByDate(Date date) {
        return null;
    }

    /**
     * 通过库管员名称查找入库表
     * @param name
     * @return
     */
    @Override
    public List<GoodIn> findGoodInListByClerkName(String name) {
        return null;
    }
}
