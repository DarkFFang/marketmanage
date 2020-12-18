package com.fang.marketmanage.controller.admin;

import com.fang.marketmanage.annotation.CustomLog;
import com.fang.marketmanage.entity.SysLog;
import com.fang.marketmanage.service.SysLogService;
import com.fang.marketmanage.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * 系统日志控制器
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
@RequestMapping("/admin/log")
public class SysLogController {
    /**
     * 系统日志服务
     */
    @Autowired
    private SysLogService sysLogService;

    /**
     * 系统日志列表
     *
     * @return {@link List<SysLog>}
     */
    @GetMapping("/sys_log")
    @PreAuthorize("hasAuthority('/admin/log/**;GET')")
    public List<SysLog> findSysLogList() {
        List<SysLog> sysLogList = sysLogService.findSysLogList();
        Collections.reverse(sysLogList);
        return sysLogList;
    }

    /**
     * 登录日志列表
     *
     * @return {@link List<SysLog>}
     */
    @GetMapping("/login_log")
    @PreAuthorize("hasAuthority('/admin/log/**;GET')")
    public List<SysLog> findLoginLogList() {
        List<SysLog> sysLogList = sysLogService.findLoginLogList();
        Collections.reverse(sysLogList);
        return sysLogList;
    }

    @DeleteMapping("/login_log")
    @PreAuthorize("hasAuthority('/admin/log/**;DELETE')")
    public RespUtil deleteAllLoginLog() {
        if (sysLogService.deleteAllLoginLog() > 0) {
            return RespUtil.success("删除成功！");
        }
        return RespUtil.error("删除失败！");
    }


    @DeleteMapping("/sys_log")
    @PreAuthorize("hasAuthority('/admin/log/**;DELETE')")
    public RespUtil deleteAllSysLog() {
        if (sysLogService.deleteAllSysLog() > 0) {
            return RespUtil.success("删除成功！");
        }
        return RespUtil.error("删除失败！");
    }
}
