package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.GoodType;

import java.util.List;

public interface GoodTypeService {
    int addNewGoodType(GoodType goodType);

    List<GoodType> findGoodTypeList();

}
