package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Good;
import com.fang.marketmanage.entity.Inventory;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface InventoryMapper {
    int addNewInventory(Inventory inventory);//增加盘存表

    int deleteInventoryById(Integer id);//删除盘存表

    int deleteAllInventory();//删除所有盘存表

    List<Inventory> findInventoryList();//盘存列表

    List<Inventory> updateInventoryListById(Integer id);//修改盘存表(仅修改实际数量)

    List<Inventory> findInventoryListByDate(Date date);//通过时间查询盘存表
}
