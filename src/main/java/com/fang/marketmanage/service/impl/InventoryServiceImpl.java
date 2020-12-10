package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.InventoryMapper;
import com.fang.marketmanage.dao.StockMapper;
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
    @Autowired
    private StockMapper stockMapper;

    @Override
    public int addNewInventoryList(List<Inventory> inventoryList) {
        int count=0;
        for (Inventory inventory:inventoryList){
            count+=inventoryMapper.addNewInventory(inventory);
            stockMapper.updateStockQuantityByGoodId(inventory.getGoodId(), inventory.getNewQuantity());
        }
        return count;
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
        return inventoryMapper.findInventoryListByDate(date);
    }

    @Override
    public int addNewInventoryRecord() {
        InventoryRecord inventoryRecord = new InventoryRecord();
        inventoryRecord.setDate(new Date());
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
