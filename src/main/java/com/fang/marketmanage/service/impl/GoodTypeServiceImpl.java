package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.GoodTypeMapper;
import com.fang.marketmanage.entity.GoodType;
import com.fang.marketmanage.service.GoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodTypeServiceImpl implements GoodTypeService {
    @Autowired
    private GoodTypeMapper goodTypeMapper;

    @Override
    public int addNewGoodType(GoodType goodType) {
        return goodTypeMapper.addNewGoodType(goodType);
    }

    @Override
    public List<GoodType> findGoodTypeList() {
        return goodTypeMapper.findGoodTypeList();
    }

}
