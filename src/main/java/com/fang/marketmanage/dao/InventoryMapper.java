package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Good;
import com.fang.marketmanage.entity.Inventory;

import java.util.Date;
import java.util.List;

public interface InventoryMapper {
    int addNewInventory(Inventory inventory);//增加盘存表
    int deleteInventoryById(Integer id);//删除盘存表
    int deleteAllInventory();//删除所有盘存表
    List<Inventory> findInventoryList();//盘存列表
    List<Inventory> updateInventoryListById(Integer id);//填写盘存表
    List<Inventory> findInventoryListByDate(Date date);//通过时间查询盘存表
}
