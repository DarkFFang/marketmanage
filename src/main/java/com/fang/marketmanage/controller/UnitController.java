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

/**
 * 单位控制器
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
public class UnitController {
    /**
     * 单位服务
     */
    @Autowired
    private UnitService unitService;

    /**
     * 单位列表
     *
     * @return {@link List<Unit>}
     */
    @GetMapping("/unit")
    public List<Unit> findUnitList() {
        return unitService.findUnitList();
    }

    /**
     * 添加新单位
     *
     * @param unit 单位
     * @return {@link RespUtil}
     */
    @PostMapping("/unit")
    @CustomLog(operation = "添加单位")
    public RespUtil addNewUnit(Unit unit) {
        if (unitService.addNewUnit(unit) == 1) {
            return RespUtil.success("添加成功！");
        }
        return RespUtil.error("添加失败！");
    }
}
