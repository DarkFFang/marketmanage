package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.GoodOutMapper;
import com.fang.marketmanage.dao.StockMapper;
import com.fang.marketmanage.entity.GoodOut;
import com.fang.marketmanage.service.GoodOutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 *  服务实现 {@code GoodOutServiceImpl} 商品出库表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Slf4j
@Service
public class GoodOutServiceImpl implements GoodOutService {
    /**
     * 实例GoodOutMapper
     */
    @Autowired
    private GoodOutMapper goodOutMapper;
    /**
     * 实例StockMapper
     */
    @Autowired
    private StockMapper stockMapper;

    /**
     * 增加商品出库表项
     * @param goodOut
     * @return
     */
    @Override
    public int addNewGoodOut(GoodOut goodOut) {
        /**
         * 增加商品出库表项,同步库存表
         */
        stockMapper.updateStockQuantityDecByGoodId(goodOut.getGoodId(), goodOut.getQuantity());
        goodOut.setDate(new Date());
        return goodOutMapper.addNewGoodOut(goodOut);
    }

    /**
     * 商品出库列表
     * @return
     */
    @Override
    public List<GoodOut> findGoodOutList() {
        /**
         * 调用出库列表方法
         */
        return goodOutMapper.findGoodOutList();
    }

    /**
     * 删除商品出库表项
     * @param id
     * @return
     */
    @Override
    public int deleteGoodOutById(Integer id) {
        /**
         * 删除商品出库表项,同步库存表
         */
        GoodOut goodOut = goodOutMapper.findGoodOutById(id);
        int result = goodOutMapper.deleteGoodOutById(id);
        if (result == 1) {
            stockMapper.updateStockQuantityIncByGoodId(goodOut.getGoodId(), goodOut.getQuantity());
            goodOutMapper.alterGoodOutAutoIncrement();
        }
        return result;
    }

    /**
     * 修改商品出库表项
     * @param goodOut
     * @return
     */
    @Override
    public int updateGoodOutById(GoodOut goodOut) {
        /**
         * 修改商品出库表项,同步库存表
         */
        log.warn(goodOut.toString());
        Integer oldQuantity = goodOutMapper.findGoodOutById(goodOut.getId()).getQuantity();
        int result = goodOutMapper.updateGoodOutById(goodOut);
        if (result == 1) {
            GoodOut newGoodOut = goodOutMapper.findGoodOutById(goodOut.getId());
            stockMapper.updateStockQuantityDecByGoodId(newGoodOut.getGoodId(), newGoodOut.getQuantity() - oldQuantity);
        }
        return result;
    }

    /**
     * 通过商品名称查找商品出库表项
     * @param name
     * @return
     */
    @Override
    public List<GoodOut> findGoodOutListByName(String name) {
        return null;
    }

    /**
     * 通过时间查找商品出库表项
     * @param date
     * @return
     */
    @Override
    public List<GoodOut> findGoodOutListByDate(Date date) {
        return null;
    }

    /**
     * 通过营业员名称查询商品出库表
     * @param name
     * @return
     */
    @Override
    public List<GoodOut> findGoodOutListByKeeperName(String name) {
        return null;
    }
}
