package com.fang.marketmanage.controller;

import com.fang.marketmanage.annotation.CustomLog;
import com.fang.marketmanage.entity.WorkTime;
import com.fang.marketmanage.service.WorkTimeService;
import com.fang.marketmanage.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 工作时间控制器
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
public class WorkTimeController {
    /**
     * 工作时间服务
     */
    @Autowired
    WorkTimeService workTimeService;

    /**
     * 工作时间列表
     *
     * @return {@link List<WorkTime>}
     */
    @GetMapping("/worktime")
    @PreAuthorize("hasAuthority('/worktime/**;GET')")
    public List<WorkTime> findWorkTimeList() {
        return workTimeService.findWorkTimeList();
    }

    /**
     * 添加新的工作时间
     *
     * @param worktime 工作时间
     * @return {@link RespUtil}
     */
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

    /**
     * 通过id删除工作时间
     *
     * @param userid 用户编码
     * @return {@link RespUtil}
     */
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

    /**
     * 通过id更新工作时间
     *
     * @param worktime 工作时间
     * @return {@link RespUtil}
     */
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
