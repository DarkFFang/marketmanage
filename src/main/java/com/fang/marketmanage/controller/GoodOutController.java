package com.fang.marketmanage.controller;

import com.fang.marketmanage.entity.GoodOut;
import com.fang.marketmanage.service.GoodOutService;
import com.fang.marketmanage.util.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodOutController {
    @Autowired
    GoodOutService goodOutService;

    @GetMapping("/goodout")
    @PreAuthorize("hasAuthority('/goodout/**;GET')")
    public List<GoodOut> findGoodOutList() {
        return goodOutService.findGoodOutList();
    }
    @PostMapping("/goodout")
    @PreAuthorize("hasAuthority('/goodout/**;POST')")
    public Resp addNewGoodOut(GoodOut goodOut) {
        if (goodOutService.addNewGoodOut(goodOut) == 1) {
            return Resp.success("添加成功！");
        } else {
            return Resp.error("添加失败！");
        }
    }
    @DeleteMapping("/goodout/{id}")
    @PreAuthorize("hasAuthority('/goodout/**;DELETE')")
    public Resp deleteGoodOutById(@PathVariable Integer id) {
        if (goodOutService.deleteGoodOutById(id) == 1) {
            return Resp.success("删除成功！");
        } else {
            return Resp.error("删除失败！");
        }
    }
    @PutMapping("/goodout")
    @PreAuthorize("hasAuthority('/goodout/**;PUT')")
    public Resp updateGoodOutById(GoodOut goodOut) {
        if (goodOutService.updateGoodOutById(goodOut) == 1) {
            return Resp.success("修改成功！");
        } else {
            return Resp.error("修改失败！");
        }
    }
}
