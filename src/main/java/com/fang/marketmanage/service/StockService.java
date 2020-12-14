package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.Stock;

import java.util.List;
/**
 * 服务 {@code StockService} 商品库存表.
 *
 * @author fang
 * @since 2020/12/14
 */
public interface StockService {

    /**
     * 库存列表
     * @return
     */
    List<Stock> findStockList();

    /**
     * 增加库存
     * @param stock
     * @return
     */
    int addNewStock(Stock stock);

    /**
     * 删除库存
     * @param id
     * @return
     */
    int deleteStockById(Integer id);

    /**
     * 修改库存
     * @param stock
     * @return
     */
    int updateStockById(Stock stock);

    /**
     * 通过商品名称查询该商品库存
     * @param name
     * @return
     */
    Stock findStockByName(String name);

    /**
     * 通过类型查询该类型商品的库存
     * @param name
     * @return
     */
    List<Stock> finStockListByType(String name);

}
