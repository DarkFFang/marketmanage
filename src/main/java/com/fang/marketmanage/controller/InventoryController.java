package com.fang.marketmanage.controller;

import com.fang.marketmanage.annotation.CustomLog;
import com.fang.marketmanage.entity.Inventory;
import com.fang.marketmanage.entity.InventoryRecord;
import com.fang.marketmanage.service.InventoryService;
import com.fang.marketmanage.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventory/record")
    @PreAuthorize("hasAuthority('/inventory/**;GET')")
    public List<InventoryRecord> findInventoryRecordList() {
        return inventoryService.findInventoryRecordList();
    }

    @PostMapping("/inventory/record")
    @PreAuthorize("hasAuthority('/inventory/**;POST')")
    @CustomLog(operation = "添加盘存表")
    public RespUtil addNewInventoryRecord() {
        if (inventoryService.addNewInventoryRecord() == 1) {
            return RespUtil.success("添加成功！");
        }
        return RespUtil.error("添加失败！");
    }

    @GetMapping("/inventory/{date}")
    @PreAuthorize("hasAuthority('/inventory/**;GET')")
    public List<Inventory> findInventoryListByDate(@PathVariable Date date) {
        return inventoryService.findInventoryListByDate(date);
    }

    @PostMapping("/inventory")
    @PreAuthorize("hasAuthority('/inventory/**;POST')")
    @CustomLog(operation = "盘点库存")
    public RespUtil addNewInventoryList(@RequestBody List<Inventory> inventoryList){
        if (inventoryService.addNewInventoryList(inventoryList) == inventoryList.size()) {
            return RespUtil.success("添加成功！");
        }
        return RespUtil.error("添加失败！");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
