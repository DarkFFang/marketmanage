package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.Inventory;
import com.fang.marketmanage.entity.InventoryRecord;

import java.util.Date;
import java.util.List;

public interface InventoryService {

    int addNewInventoryList(List<Inventory> inventoryList);//增加盘存表

    int deleteInventoryById(Integer id);//删除盘存表

    int deleteAllInventory();//删除所有盘存表

    List<Inventory> findInventoryList();//盘存列表

    int updateInventoryListById(Inventory inventory);//修改盘存表(仅修改实际数量)

    List<Inventory> findInventoryListByDate(Date date);//通过时间查询盘存表

    int addNewInventoryRecord();

    List<InventoryRecord> findInventoryRecordList();

    InventoryRecord findInventoryRecordById(Integer id);
}
