package com.fang.marketmanage.controller;

import com.fang.marketmanage.entity.Inventory;
import com.fang.marketmanage.entity.InventoryRecord;
import com.fang.marketmanage.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventoryrecord")
    public List<InventoryRecord> findInventoryRecordList() {
        return inventoryService.findInventoryRecordList();
    }

    @GetMapping("/inventory/{date}")
    public List<Inventory> findInventoryListByDate(@PathVariable Date date) {
        return inventoryService.findInventoryListByDate(date);
    }
}
