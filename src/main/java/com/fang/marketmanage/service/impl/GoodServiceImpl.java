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

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper goodMapper;

    @Autowired
    private StockMapper stockMapper;

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

    @Override
    public List<Good> findGoodList() {
        return goodMapper.findGoodList();
    }

    @Override
    public int deleteGoodById(Integer id) {
        return goodMapper.deleteGoodById(id);
    }

    @Override
    public int updateGoodById(Good good) {
        return goodMapper.updateGoodById(good);
    }

    @Override
    public Good findGoodByName(String name) {
        return null;
    }

    @Override
    public List<Good> findGoodListByType(String name) {
        return null;
    }

    @Override
    public void alterGoodAutoIncrement() {
        goodMapper.alterGoodAutoIncrement();
    }
}
