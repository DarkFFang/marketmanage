package com.fang.marketmanage.controller;

import com.fang.marketmanage.entity.GoodOut;
import com.fang.marketmanage.service.GoodOutService;
import com.fang.marketmanage.util.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodOutController {
    @Autowired
    GoodOutService goodOutService;

    @GetMapping("/goodout")
    public List<GoodOut> findGoodOutList() {
        return goodOutService.findGoodOutList();
    }
    @PostMapping("/goodout")
    public Resp addNewGoodOut(GoodOut goodOut) {
        if (goodOutService.addNewGoodOut(goodOut) == 1) {
            return Resp.success("添加成功！");
        } else {
            return Resp.error("添加失败！");
        }
    }
    @DeleteMapping("/goodout/{id}")
    public Resp deleteGoodOutById(@PathVariable Integer id) {
        if (goodOutService.deleteGoodOutById(id) == 1) {
            return Resp.success("删除成功！");
        } else {
            return Resp.error("删除失败！");
        }
    }
    @PutMapping("/goodout")
    public Resp updateGoodOutById(GoodOut goodOut) {
        if (goodOutService.updateGoodOutById(goodOut) == 1) {
            return Resp.success("修改成功！");
        } else {
            return Resp.error("修改失败！");
        }
    }
}
