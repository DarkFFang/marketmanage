package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockMapper {
    int findStockList();//库存列表

    Stock findStockByName(String name);//通过商品名称查询该商品库存

    List<Stock> finStockListByType(String name);//通过类型查询该类型商品的库存
}
