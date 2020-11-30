package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.GoodMapper;
import com.fang.marketmanage.entity.Good;
import com.fang.marketmanage.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    GoodMapper goodMapper;

    @Override
    public int addNewGood(Good good) {
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
    public Integer findMaxId() {
        return goodMapper.findMaxId();
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
