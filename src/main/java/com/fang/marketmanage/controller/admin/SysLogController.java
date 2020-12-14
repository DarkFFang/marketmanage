package com.fang.marketmanage.controller.admin;

import com.fang.marketmanage.annotation.CustomLog;
import com.fang.marketmanage.entity.SysLog;
import com.fang.marketmanage.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/log")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    @GetMapping("/sys_log")
    @PreAuthorize("hasAuthority('/admin/log/**;GET')")
    public List<SysLog> findSysLogList() {
        return sysLogService.findSysLogList();
    }

    @GetMapping("/login_log")
    @PreAuthorize("hasAuthority('/admin/log/**;GET')")
    public List<SysLog> findLoginLogList() {
        return sysLogService.findLoginLogList();
    }
}
