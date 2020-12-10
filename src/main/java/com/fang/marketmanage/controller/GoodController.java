package com.fang.marketmanage.controller;


import com.fang.marketmanage.annotation.CustomLog;
import com.fang.marketmanage.entity.Good;
import com.fang.marketmanage.service.GoodService;
import com.fang.marketmanage.service.StockService;
import com.fang.marketmanage.util.RespUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class GoodController {
    @Autowired
    GoodService goodService;

    @Autowired
    StockService stockService;

    @GetMapping("/good")
    @PreAuthorize("hasAuthority('/good/**;GET')")
    public List<Good> findGoodList() {
        log.debug(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString());
        return goodService.findGoodList();
    }

    @PostMapping("/good")
    @PreAuthorize("hasAuthority('/good/**;POST')")
    @CustomLog(operation = "添加商品")
    public RespUtil addNewGood(Good good) {
        if (goodService.addNewGood(good) == 1) {
            return RespUtil.success("添加成功！");
        } else {
            return RespUtil.error("添加失败！");
        }
    }

    @PutMapping("/good")
    @PreAuthorize("hasAuthority('/good/**;PUT')")
    @CustomLog(operation = "修改商品")
    public RespUtil updateGoodById(Good good) {
        if (goodService.updateGoodById(good) == 1) {
            return RespUtil.success("修改成功！");
        } else {
            return RespUtil.error("修改失败！");
        }
    }

    @DeleteMapping("/good/{id}")
    @PreAuthorize("hasAuthority('/good/**;DELETE')")
    @CustomLog(operation = "删除商品")
    public RespUtil deleteGoodById(@PathVariable Integer id) {
        if (goodService.deleteGoodById(id) == 1) {
            return RespUtil.success("删除成功！");
        } else {
            return RespUtil.error("删除失败！");
        }
    }


}
