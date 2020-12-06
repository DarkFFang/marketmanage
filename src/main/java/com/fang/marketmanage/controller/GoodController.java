package com.fang.marketmanage.controller;


import com.fang.marketmanage.entity.Good;
import com.fang.marketmanage.entity.Stock;
import com.fang.marketmanage.service.GoodService;
import com.fang.marketmanage.service.StockService;
import com.fang.marketmanage.util.Resp;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public Resp addNewGood(Good good) {
        if (goodService.addNewGood(good) == 1) {
            return Resp.success("添加成功！");
        } else {
            return Resp.error("添加失败！");
        }
    }

    @PutMapping("/good")
    @PreAuthorize("hasAuthority('/good/**;PUT')")
    public Resp updateGoodById(Good good) {
        if (goodService.updateGoodById(good) == 1) {
            return Resp.success("修改成功！");
        } else {
            return Resp.error("修改失败！");
        }
    }

    @DeleteMapping("/good/{id}")
    @PreAuthorize("hasAuthority('/good/**;DELETE')")
    public Resp deleteGoodById(@PathVariable Integer id) {
        if (goodService.deleteGoodById(id) == 1) {
            return Resp.success("删除成功！");
        } else {
            return Resp.error("删除失败！");
        }
    }


}
