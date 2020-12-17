package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.Inventory;
import com.fang.marketmanage.entity.InventoryRecord;

import java.util.Date;
import java.util.List;
/**
 * 服务 {@code InventoryService} 商品盘存表.
 *
 * @author fang
 * @since 2020/12/14
 */
public interface InventoryService {

    /**
     * 增加盘存表
     * @param inventoryList
     * @return
     */
    int addNewInventoryList(List<Inventory> inventoryList);

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
     * 增加商品盘存目录
     * @return
     */
    int addNewInventoryRecord();

    /**
     * 商品盘存目录列表
     * @return
     */
    List<InventoryRecord> findInventoryRecordList();

    /**
     * 通过id查找商品目录
     * @param id
     * @return
     */
    InventoryRecord findInventoryRecordById(Integer id);

    int deleteInventoryRecordById(Integer id);
}
