package com.fang.marketmanage.controller;

import com.fang.marketmanage.annotation.CustomLog;
import com.fang.marketmanage.entity.WorkTime;
import com.fang.marketmanage.service.WorkTimeService;
import com.fang.marketmanage.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkTimeController {
    @Autowired
    WorkTimeService workTimeService;

    @GetMapping("/worktime")
    @PreAuthorize("hasAuthority('/worktime/**;GET')")
    public List<WorkTime> findWorkTimeList() {
        return workTimeService.findWorkTimeList();
    }
    @PostMapping("/worktime")
    @PreAuthorize("hasAuthority('/worktime/**;POST')")
    @CustomLog(operation = "添加时间表")
    public RespUtil addNewWorkTime(WorkTime worktime) {
        if (workTimeService.addNewWorkTime(worktime) == 1) {
            return RespUtil.success("添加成功！");
        } else {
            return RespUtil.error("添加失败！");
        }
    }
    @DeleteMapping("/worktime/{userid}")
    @PreAuthorize("hasAuthority('/worktime/**;DELETE')")
    @CustomLog(operation = "删除时间表项")
    public RespUtil deleteWorkTimeById(@PathVariable Integer userid) {
        if (workTimeService.deleteWorkTimeById(userid) == 1) {
            return RespUtil.success("删除成功！");
        } else {
            return RespUtil.error("删除失败！");
        }
    }
    @PutMapping("/worktime")
    @PreAuthorize("hasAuthority('/worktime/**;PUT')")
    @CustomLog(operation = "修改时间表项")
    public RespUtil updateWorkTimeById(WorkTime worktime) {
        if (workTimeService.updateWorkTimeById(worktime) == 1) {
            return RespUtil.success("修改成功！");
        } else {
            return RespUtil.error("修改失败！");
        }
    }
}
