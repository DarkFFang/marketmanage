package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.GoodMapper;
import com.fang.marketmanage.dao.StockMapper;
import com.fang.marketmanage.entity.Good;
import com.fang.marketmanage.entity.Stock;
import com.fang.marketmanage.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 * 服务实现 {@code GoodServiceImpl} 商品表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Service
public class GoodServiceImpl implements GoodService {
    /**
     * 实例GoodMapper
     */
    @Autowired
    private GoodMapper goodMapper;
    /**
     * 实例StockMapper
     */
    @Autowired
    private StockMapper stockMapper;

    /**
     * 增加商品
     * @param good
     * @return
     */
    @Override
    public int addNewGood(Good good) {
        Integer id = goodMapper.findMaxId() + 1;
        good.setId(id);
        Stock stock = new Stock();
        stock.setGoodId(good.getId());
        stock.setUnitId(good.getUnitId());
        stock.setDate(new Date());
        stockMapper.addNewStock(stock);
        return goodMapper.addNewGood(good);
    }

    /**
     * 商品列表
     * @return
     */
    @Override
    public List<Good> findGoodList() {
        return goodMapper.findGoodList();
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @Override
    public int deleteGoodById(Integer id) {
        return goodMapper.deleteGoodById(id);
    }

    /**
     * 修改商品
     * @param good
     * @return
     */
    @Override
    public int updateGoodById(Good good) {
        return goodMapper.updateGoodById(good);
    }

    /**
     * 通过名称查找商品
     * @param name
     * @return
     */
    @Override
    public Good findGoodByName(String name) {
        return null;
    }

    /**
     * 通过类型查找商品
     * @param name
     * @return
     */
    @Override
    public List<Good> findGoodListByType(String name) {
        return null;
    }

    /**
     * 主键自增
     */
    @Override
    public void alterGoodAutoIncrement() {
        goodMapper.alterGoodAutoIncrement();
    }
}
