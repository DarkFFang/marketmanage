package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.GoodInMapper;
import com.fang.marketmanage.dao.StockMapper;
import com.fang.marketmanage.entity.Good;
import com.fang.marketmanage.entity.GoodIn;
import com.fang.marketmanage.entity.Stock;
import com.fang.marketmanage.service.GoodInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Slf4j
@Service
public class GoodInServiceImpl implements GoodInService {
    @Autowired
    GoodInMapper goodInMapper;
    @Autowired
    StockMapper stockMapper;

    @Override
    public int addNewGoodIn(GoodIn goodIn) {
        stockMapper.updateStockQuantityIncByGoodId(goodIn.getGoodId(), goodIn.getQuantity());
        goodIn.setDate(new Date());
        return goodInMapper.addNewGoodIn(goodIn);
    }

    @Override
    public List<GoodIn> findGoodInList() {
        return goodInMapper.findGoodInList();
    }

    @Override
    public int deleteGoodInById(Integer id) {
        GoodIn goodIn = goodInMapper.findGoodInById(id);
        int result = goodInMapper.deleteGoodInById(id);
        if (result == 1) {
            stockMapper.updateStockQuantityDecByGoodId(goodIn.getGoodId(), goodIn.getQuantity());
            goodInMapper.alterGoodInAutoIncrement();
        }
        return result;
    }

    @Override
    public int updateGoodInById(GoodIn goodIn) {
        log.warn(goodIn.toString());
        Integer oldQuantity = goodInMapper.findGoodInById(goodIn.getId()).getQuantity();
        int result = goodInMapper.updateGoodInById(goodIn);
        if (result == 1) {
            GoodIn newGoodIn=goodInMapper.findGoodInById(goodIn.getId());
            stockMapper.updateStockQuantityIncByGoodId(newGoodIn.getGoodId(), newGoodIn.getQuantity() - oldQuantity);
        }
        return result;
    }

    @Override
    public List<GoodIn> findGoodInListByName(String name) {
        return null;
    }

    @Override
    public List<GoodIn> findGoodInListByDate(Date date) {
        return null;
    }

    @Override
    public List<GoodIn> findGoodInListByClerkName(String name) {
        return null;
    }
}
