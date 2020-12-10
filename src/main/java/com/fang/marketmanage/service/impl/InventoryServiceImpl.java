package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.InventoryMapper;
import com.fang.marketmanage.entity.Inventory;
import com.fang.marketmanage.entity.InventoryRecord;
import com.fang.marketmanage.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public int addNewInventory(Inventory inventory) {
        return inventoryMapper.addNewInventory(inventory);
    }

    @Override
    public int deleteInventoryById(Integer id) {
        return 0;
    }

    @Override
    public int deleteAllInventory() {
        return 0;
    }

    @Override
    public List<Inventory> findInventoryList() {
        return null;
    }

    @Override
    public int updateInventoryListById(Inventory inventory) {
        return 0;
    }

    @Override
    public List<Inventory> findInventoryListByDate(Date date) {
        return null;
    }

    @Override
    public int addNewInventoryRecord(InventoryRecord inventoryRecord) {
        return inventoryMapper.addNewInventoryRecord(inventoryRecord);
    }

    @Override
    public List<InventoryRecord> findInventoryRecordList() {
        return inventoryMapper.findInventoryRecordList();
    }

    @Override
    public InventoryRecord findInventoryRecordById(Integer id) {
        return null;
    }
}
