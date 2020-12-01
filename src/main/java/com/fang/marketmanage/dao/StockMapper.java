package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockMapper {
    List<Stock> findStockList();//库存列表

    int addNewStock(Stock stock);//增加库存

    int deleteStockById(Integer id);//删除库存

    int updateStockQuantityIncByGoodId(Integer goodid,Integer increment);//修改库存增加数量

    int updateStockQuantityDecByGoodId(Integer goodid,Integer decrement);//修改库存减少数量

    Stock findStockByName(String name);//通过商品名称查询该商品库存

    List<Stock> finStockListByType(String name);//通过类型查询该类型商品的库存

    void alterStockAutoIncrement();
}
