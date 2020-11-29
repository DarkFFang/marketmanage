package com.fang.marketmanage.controller;

import com.fang.marketmanage.entity.GoodIn;
import com.fang.marketmanage.service.GoodInService;
import com.fang.marketmanage.util.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodInController {
    @Autowired
    GoodInService goodInService;

    @GetMapping("/goodin")
    public List<GoodIn> findGoodInList() {
        return goodInService.findGoodInList();
    }
    @PostMapping("/goodin")
    public Resp addNewGoodIn(GoodIn goodIn) {
        if (goodInService.addNewGoodIn(goodIn) == 1) {
            return Resp.success("添加成功！");
        } else {
            return Resp.error("添加失败！");
        }
    }
    @DeleteMapping("/goodin")
    public Resp deleteGoodInById(Integer id) {
        if (goodInService.deleteGoodInById(id) == 1) {
            return Resp.success("添加成功！");
        } else {
            return Resp.error("添加失败！");
        }
    }
    @PutMapping("/goodin")
    public Resp updateGoodInById(GoodIn goodIn) {
        if (goodInService.updateGoodInById(goodIn) == 1) {
            return Resp.success("添加成功！");
        } else {
            return Resp.error("添加失败！");
        }
    }
}
