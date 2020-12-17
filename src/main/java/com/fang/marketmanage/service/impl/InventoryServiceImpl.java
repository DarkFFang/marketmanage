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

/**
 * 盘存服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@Service
public class InventoryServiceImpl implements InventoryService {
    /**
     * 盘存映射器
     */
    @Autowired
    private InventoryMapper inventoryMapper;
    /**
     * 库存映射器
     */
    @Autowired
    private StockMapper stockMapper;

    /**
     * 添加新的盘存列表
     *
     * @param inventoryList 盘存清单
     * @return int
     */
    @Override
    public int addNewInventoryList(List<Inventory> inventoryList) {
        int count=0;
        for (Inventory inventory:inventoryList){
            count+=inventoryMapper.addNewInventory(inventory);
            stockMapper.updateStockQuantityByGoodId(inventory.getGoodId(), inventory.getNewQuantity());
        }
        return count;
    }

    /**
     * 通过id删除盘存目录
     *
     * @param id id
     * @return int
     */
    @Override
    public int deleteInventoryById(Integer id) {
        return 0;
    }

    /**
     * 删除所有盘存
     *
     * @return int
     */
    @Override
    public int deleteAllInventory() {
        return 0;
    }

    /**
     * 盘存列表
     *
     * @return {@link List<Inventory>}
     */
    @Override
    public List<Inventory> findInventoryList() {
        return null;
    }

    /**
     * 更新盘存
     *
     * @param inventory 库存
     * @return int
     */
    @Override
    public int updateInventoryListById(Inventory inventory) {
        return 0;
    }

    /**
     * 按日期查找盘存列表
     *
     * @param date 日期
     * @return {@link List<Inventory>}
     */
    @Override
    public List<Inventory> findInventoryListByDate(Date date) {
        return inventoryMapper.findInventoryListByDate(date);
    }

    /**
     * 添加新的盘存记录
     *
     * @return int
     */
    @Override
    public int addNewInventoryRecord() {
        InventoryRecord inventoryRecord = new InventoryRecord();
        inventoryRecord.setDate(new Date());
        return inventoryMapper.addNewInventoryRecord(inventoryRecord);
    }

    /**
     * 盘存记录列表
     *
     * @return {@link List<InventoryRecord>}
     */
    @Override
    public List<InventoryRecord> findInventoryRecordList() {
        return inventoryMapper.findInventoryRecordList();
    }

    /**
     * 通过id查找盘存记录
     *
     * @param id id
     * @return {@link InventoryRecord}
     */
    @Override
    public InventoryRecord findInventoryRecordById(Integer id) {
        return null;
    }

    @Override
    public int deleteInventoryRecordById(Integer id) {
        InventoryRecord inventoryRecord = inventoryMapper.findInventoryRecordById(id);
        inventoryMapper.deleteInventoryByDate(inventoryRecord.getDate());
        return inventoryMapper.deleteInventoryRecordById(inventoryRecord.getId());
    }
}
