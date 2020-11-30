package com.fang.marketmanage.controller;

import com.fang.marketmanage.entity.Stock;
import com.fang.marketmanage.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {
    @Autowired
    StockService stockService;

    @GetMapping("/stock")
    public List<Stock> findStockList() {
        return stockService.findStockList();
    }
}
