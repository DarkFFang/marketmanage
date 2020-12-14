package com.fang.marketmanage.controller;

import com.fang.marketmanage.entity.Stock;
import com.fang.marketmanage.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 库存控制器
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
public class StockController {
    /**
     * 库存服务
     */
    @Autowired
    private StockService stockService;

    /**
     * 查找库存列表
     *
     * @return {@link List<Stock>}
     */
    @GetMapping("/stock")
    @PreAuthorize("hasAuthority('/stock/**;GET')")
    public List<Stock> findStockList() {
        return stockService.findStockList();
    }
}
