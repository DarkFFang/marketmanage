package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.StockMapper;
import com.fang.marketmanage.entity.Stock;
import com.fang.marketmanage.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StockServiceImpl implements StockService {
    @Autowired
    StockMapper stockMapper;

    @Override
    public List<Stock> findStockList() {
        return stockMapper.findStockList();
    }

    @Override
    public int addNewStock(Stock stock) {
        return stockMapper.addNewStock(stock);
    }

    @Override
    public int deleteStockById(Integer id) {
        return stockMapper.deleteStockById(id);
    }

    @Override
    public int updateStockById(Stock stock) {
        return stockMapper.updateStockById(stock);
    }

    @Override
    public Stock findStockByName(String name) {
        return null;
    }

    @Override
    public List<Stock> finStockListByType(String name) {
        return null;
    }
}
