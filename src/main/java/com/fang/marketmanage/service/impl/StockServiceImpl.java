package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.StockMapper;
import com.fang.marketmanage.entity.Stock;
import com.fang.marketmanage.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 库存服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@Service
public class StockServiceImpl implements StockService {
    /**
     * 库存映射器
     */
    @Autowired
    private StockMapper stockMapper;

    /**
     * 库存列表
     *
     * @return {@link List<Stock>}
     */
    @Override
    public List<Stock> findStockList() {
        return stockMapper.findStockList();
    }

    /**
     * 添加新的库存
     *
     * @param stock 股票
     * @return int
     */
    @Override
    public int addNewStock(Stock stock) {
        return stockMapper.addNewStock(stock);
    }

    /**
     * 通过id删除库存
     *
     * @param id id
     * @return int
     */
    @Override
    public int deleteStockById(Integer id) {
        return stockMapper.deleteStockById(id);
    }

    /**
     * 通过id更新库存
     *
     * @param stock 库存
     * @return int
     */
    @Override
    public int updateStockById(Stock stock) {
       return 0;
    }

    /**
     * 通过商品名称查询库存
     *
     * @param name 名字
     * @return {@link Stock}
     */
    @Override
    public Stock findStockByName(String name) {
        return null;
    }

    /**
     * 库存列表类型列表
     *
     * @param name 的名字
     * @return {@link List<Stock>}
     */
    @Override
    public List<Stock> finStockListByType(String name) {
        return null;
    }

}
