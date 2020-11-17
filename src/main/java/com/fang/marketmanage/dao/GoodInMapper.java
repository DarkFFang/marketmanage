package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Good;
import com.fang.marketmanage.entity.GoodIn;

import java.util.Date;
import java.util.List;

public interface GoodInMapper {
    int addNewGoodIn(GoodIn goodin);//添加入库单
    List<GoodIn> findGoodInList();//入库单列表
    int deleteGoodInById(Integer id);//删除入库表一项
    Good updateGoodInById(Integer id);//修改入库单信息
    List<GoodIn> findGoodInListByName(String name);//通过商品名称查询入库单列表
    List<GoodIn> findGoodInListByDate(Date date);//通过时间查询入库单列表
    List<GoodIn> findGoodInListByClerkName(String name);//通过库管员姓名查询入库单列表
}
