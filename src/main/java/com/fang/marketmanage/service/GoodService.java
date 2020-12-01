package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.Good;

import java.util.List;

public interface GoodService {
    int addNewGood(Good good);//增加商品

    List<Good> findGoodList();//商品列表

    int deleteGoodById(Integer id);//删除商品

    int updateGoodById(Good good);//修改商品

    Good findGoodByName(String name);//通过商品名称查询商品

    List<Good> findGoodListByType(String name);//通过商品类型查询商品列表

    void alterGoodAutoIncrement();
}
