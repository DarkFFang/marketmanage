package com.fang.marketmanage.controller;

import com.fang.marketmanage.entity.GoodType;
import com.fang.marketmanage.service.GoodTypeService;
import com.fang.marketmanage.util.RespUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class GoodTypeController {
    @Autowired
    private GoodTypeService goodTypeService;

    @GetMapping("/goodtype")
    public List<GoodType> findGoodTypeList() {
        log.debug(String.format(new Date().toString()));
        return goodTypeService.findGoodTypeList();
    }

    @PostMapping("/goodtype")
    public RespUtil addNewGoodType(GoodType goodType) {
        if (goodTypeService.addNewGoodType(goodType) == 1) {
            return RespUtil.success("添加成功！");
        }
        return RespUtil.error("添加失败");
    }

}
