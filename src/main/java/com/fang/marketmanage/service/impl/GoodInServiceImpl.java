package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.GoodInMapper;
import com.fang.marketmanage.dao.StockMapper;
import com.fang.marketmanage.entity.GoodIn;
import com.fang.marketmanage.entity.Stock;
import com.fang.marketmanage.service.GoodInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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
        return goodInMapper.deleteGoodInById(id);
    }

    @Override
    public int updateGoodInById(GoodIn goodIn) {
        return goodInMapper.updateGoodInById(goodIn);
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
