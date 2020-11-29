package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockMapper {
    List<Stock> findStockList();//库存列表

    int addNewStock(Stock stock);//增加库存

    int deleteStockById(Integer id);//删除库存

    int updateStockById(Stock stock);//修改库存

    Stock findStockByName(String name);//通过商品名称查询该商品库存

    List<Stock> finStockListByType(String name);//通过类型查询该类型商品的库存
}
