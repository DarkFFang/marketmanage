package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 接口 {@code Stock} 库存表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Mapper
public interface StockMapper {

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
     * 修改库存增加数量
     * @param goodid
     * @param increment
     * @return
     */
    int updateStockQuantityIncByGoodId(Integer goodid,Integer increment);

    /**
     * 修改库存减少数量
     * @param goodid
     * @param decrement
     * @return
     */
    int updateStockQuantityDecByGoodId(Integer goodid,Integer decrement);

    /**
     * 更新库存表商品数量
     * @param goodid
     * @param newQuantity
     * @return
     */
    int updateStockQuantityByGoodId(Integer goodid, Integer newQuantity);

    /**
     * 库存计数
     * @return
     */
    int findStockCount();

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
