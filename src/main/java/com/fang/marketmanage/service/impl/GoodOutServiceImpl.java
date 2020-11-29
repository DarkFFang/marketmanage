package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.GoodOutMapper;
import com.fang.marketmanage.entity.GoodOut;
import com.fang.marketmanage.service.GoodOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class GoodOutServiceImpl implements GoodOutService {
    @Autowired
    GoodOutMapper goodOutMapper;

    @Override
    public int addNewGoodOut(GoodOut goodout) {
        return goodOutMapper.addNewGoodOut(goodout);
    }

    @Override
    public List<GoodOut> findGoodOutList() {
        return goodOutMapper.findGoodOutList();
    }

    @Override
    public int deleteGoodOutById(Integer id) {
        return goodOutMapper.deleteGoodOutById(id);
    }

    @Override
    public int updateGoodOutById(GoodOut goodOut) {
        return goodOutMapper.updateGoodOutById(goodOut);
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
