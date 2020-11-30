package com.fang.marketmanage.controller;


import com.fang.marketmanage.entity.Good;
import com.fang.marketmanage.entity.Stock;
import com.fang.marketmanage.service.GoodService;
import com.fang.marketmanage.service.StockService;
import com.fang.marketmanage.util.Resp;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class GoodController {
    @Autowired
    GoodService goodService;

    @Autowired
    StockService stockService;

    @GetMapping("/good")
    public List<Good> findGoodList() {
        return goodService.findGoodList();
    }

    @PostMapping("/good")
    public Resp addNewGood(Good good) {
        Integer id=goodService.findMaxId()+1;
        good.setId(id);
        if (goodService.addNewGood(good) == 1) {
            Stock stock=new Stock();
            stock.setGoodId(good.getId());
            stock.setUnitId(good.getUnitId());
            stock.setDate(new Date());
            stockService.addNewStock(stock);
            return Resp.success("添加成功！");
        } else {
            return Resp.error("添加失败！");
        }
    }

    @PutMapping("/good")
    public Resp updateGoodById(Good good) {
        if (goodService.updateGoodById(good) == 1) {
            return Resp.success("修改成功！");
        } else {
            return Resp.error("修改失败！");
        }
    }

    @DeleteMapping("/good/{id}")
    public Resp deleteGoodById(@PathVariable Integer id) {
        if (goodService.deleteGoodById(id) == 1) {
            return Resp.success("删除成功！");
        } else {
            return Resp.error("删除失败！");
        }
    }


}
