package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Inventory;
import com.fang.marketmanage.entity.InventoryRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
/**
 * 接口 {@code InventoryMapper} 商品盘存表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Mapper
public interface InventoryMapper {

    /**
     * 增加盘存表
     * @param inventory
     * @return
     */
    int addNewInventory(Inventory inventory);

    /**
     * 删除盘存表
     * @param id
     * @return
     */
    int deleteInventoryById(Integer id);

    /**
     * 删除所有盘存表
     * @return
     */
    int deleteAllInventory();

    /**
     * 盘存列表
     * @return
     */
    List<Inventory> findInventoryList();

    /**
     * 修改盘存表(仅修改实际数量)
     * @param inventory
     * @return
     */
    int updateInventoryListById(Inventory inventory);

    /**
     * 通过时间查询盘存表
     * @param date
     * @return
     */
    List<Inventory> findInventoryListByDate(Date date);

    /**
     * 增加盘存目录
     * @param inventoryRecord
     * @return
     */
    int addNewInventoryRecord(InventoryRecord inventoryRecord);

    /**
     * 盘存目录列表
     * @return
     */
    List<InventoryRecord> findInventoryRecordList();

    /**
     * 通过id查询盘存目录
     * @param id
     * @return
     */
    InventoryRecord findInventoryRecordById(Integer id);

}
