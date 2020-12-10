package com.fang.marketmanage.controller;

import com.fang.marketmanage.annotation.CustomLog;
import com.fang.marketmanage.entity.Unit;
import com.fang.marketmanage.service.UnitService;
import com.fang.marketmanage.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UnitController {
    @Autowired
    private UnitService unitService;

    @GetMapping("/unit")
    public List<Unit> findUnitList() {
        return unitService.findUnitList();
    }

    @PostMapping("/unit")
    @CustomLog(operation = "添加单位")
    public RespUtil addNewUnit(Unit unit) {
        if (unitService.addNewUnit(unit) == 1) {
            return RespUtil.success("添加成功！");
        }
        return RespUtil.error("添加失败！");
    }
}
