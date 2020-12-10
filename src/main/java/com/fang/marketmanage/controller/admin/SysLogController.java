package com.fang.marketmanage.controller.admin;

import com.fang.marketmanage.entity.SysLog;
import com.fang.marketmanage.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    @GetMapping("/syslog")
    public List<SysLog> findSysLogList() {
        return sysLogService.findSysLogList();
    }
}
