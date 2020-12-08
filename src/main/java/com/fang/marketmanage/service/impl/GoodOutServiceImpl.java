package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.GoodOutMapper;
import com.fang.marketmanage.dao.StockMapper;
import com.fang.marketmanage.entity.GoodIn;
import com.fang.marketmanage.entity.GoodOut;
import com.fang.marketmanage.service.GoodOutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Slf4j
@Service
public class GoodOutServiceImpl implements GoodOutService {
    @Autowired
    GoodOutMapper goodOutMapper;
    @Autowired
    StockMapper stockMapper;

    @Override
    public int addNewGoodOut(GoodOut goodOut) {
        stockMapper.updateStockQuantityDecByGoodId(goodOut.getGoodId(), goodOut.getQuantity());
        goodOut.setDate(new Date());
        return goodOutMapper.addNewGoodOut(goodOut);
    }

    @Override
    public List<GoodOut> findGoodOutList() {
        return goodOutMapper.findGoodOutList();
    }

    @Override
    public int deleteGoodOutById(Integer id) {
        GoodOut goodOut = goodOutMapper.findGoodOutById(id);
        int result = goodOutMapper.deleteGoodOutById(id);
        if (result == 1) {
            stockMapper.updateStockQuantityIncByGoodId(goodOut.getGoodId(), goodOut.getQuantity());
            goodOutMapper.alterGoodOutAutoIncrement();
        }
        return result;
    }

    @Override
    public int updateGoodOutById(GoodOut goodOut) {
        log.warn(goodOut.toString());
        Integer oldQuantity = goodOutMapper.findGoodOutById(goodOut.getId()).getQuantity();
        int result = goodOutMapper.updateGoodOutById(goodOut);
        if (result == 1) {
            GoodOut newGoodOut=goodOutMapper.findGoodOutById(goodOut.getId());
            stockMapper.updateStockQuantityDecByGoodId(newGoodOut.getGoodId(), newGoodOut.getQuantity() - oldQuantity);
        }
        return result;
    }

    @Override
    public List<GoodOut> findGoodOutListByName(String name) {
        return null;
    }

    @Override
    public List<GoodOut> findGoodOutListByDate(Date date) {
        return null;
    }

    @Override
    public List<GoodOut> findGoodOutListByKeeperName(String name) {
        return null;
    }
}
