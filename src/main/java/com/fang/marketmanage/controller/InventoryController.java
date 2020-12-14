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

/**
 * 盘存控制器
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
public class InventoryController {
    /**
     * 盘存服务
     */
    @Autowired
    private InventoryService inventoryService;

    /**
     * 盘存记录列表
     *
     * @return {@link List<InventoryRecord>}
     */
    @GetMapping("/inventory/record")
    @PreAuthorize("hasAuthority('/inventory/**;GET')")
    public List<InventoryRecord> findInventoryRecordList() {
        return inventoryService.findInventoryRecordList();
    }

    /**
     * 添加新的盘存记录
     *
     * @return {@link RespUtil}
     */
    @PostMapping("/inventory/record")
    @PreAuthorize("hasAuthority('/inventory/**;POST')")
    @CustomLog(operation = "添加盘存表")
    public RespUtil addNewInventoryRecord() {
        if (inventoryService.addNewInventoryRecord() == 1) {
            return RespUtil.success("添加成功！");
        }
        return RespUtil.error("添加失败！");
    }

    /**
     * 按日期查询库存列表
     *
     * @param date 日期
     * @return {@link List<Inventory>}
     */
    @GetMapping("/inventory/{date}")
    @PreAuthorize("hasAuthority('/inventory/**;GET')")
    public List<Inventory> findInventoryListByDate(@PathVariable Date date) {
        return inventoryService.findInventoryListByDate(date);
    }

    /**
     * 添加新的库存列表
     *
     * @param inventoryList 库存清单
     * @return {@link RespUtil}
     */
    @PostMapping("/inventory")
    @PreAuthorize("hasAuthority('/inventory/**;POST')")
    @CustomLog(operation = "盘点库存")
    public RespUtil addNewInventoryList(@RequestBody List<Inventory> inventoryList){
        if (inventoryService.addNewInventoryList(inventoryList) == inventoryList.size()) {
            return RespUtil.success("添加成功！");
        }
        return RespUtil.error("添加失败！");
    }

    /**
     * 绑定
     *
     * @param binder 绑定
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
