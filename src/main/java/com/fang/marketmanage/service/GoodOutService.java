package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.GoodOut;

import java.util.Date;
import java.util.List;

public interface GoodOutService {
    int addNewGoodOut(GoodOut goodout); //添加出库单

    List<GoodOut> findGoodOutList(); //出库单列表

    int deleteGoodOutById(Integer id); //删除出库单一项

    int updateGoodOutById(GoodOut goodOut); //修改出库单信息

    List<GoodOut> findGoodOutListByName(String name); //通过商品名称查询出库单列表

    List<GoodOut> findGoodOutListByDate(Date date); //通过时间查询出库单列表

    List<GoodOut> findGoodOutListByKeeperName(String name); //通过营业员员姓名查询出库单列表

}
