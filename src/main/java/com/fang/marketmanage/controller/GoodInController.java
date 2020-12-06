package com.fang.marketmanage.controller;

import com.fang.marketmanage.entity.GoodIn;
import com.fang.marketmanage.service.GoodInService;
import com.fang.marketmanage.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodInController {
    @Autowired
    GoodInService goodInService;

    @GetMapping("/goodin")
    @PreAuthorize("hasAuthority('/goodin/**;GET')")
    public List<GoodIn> findGoodInList() {
        return goodInService.findGoodInList();
    }
    @PostMapping("/goodin")
    @PreAuthorize("hasAuthority('/goodin/**;POST')")
    public RespUtil addNewGoodIn(GoodIn goodIn) {
        if (goodInService.addNewGoodIn(goodIn) == 1) {
            return RespUtil.success("添加成功！");
        } else {
            return RespUtil.error("添加失败！");
        }
    }
    @DeleteMapping("/goodin/{id}")
    @PreAuthorize("hasAuthority('/goodin/**;DELETE')")
    public RespUtil deleteGoodInById(@PathVariable Integer id) {
        if (goodInService.deleteGoodInById(id) == 1) {
            return RespUtil.success("删除成功！");
        } else {
            return RespUtil.error("删除失败！");
        }
    }
    @PutMapping("/goodin")
    @PreAuthorize("hasAuthority('/goodin/**;PUT')")
    public RespUtil updateGoodInById(GoodIn goodIn) {
        if (goodInService.updateGoodInById(goodIn) == 1) {
            return RespUtil.success("修改成功！");
        } else {
            return RespUtil.error("修改失败！");
        }
    }
}
