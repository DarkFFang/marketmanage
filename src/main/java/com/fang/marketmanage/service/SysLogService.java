package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.SysLog;

import java.util.List;

public interface SysLogService {
    int addNewSysLog(SysLog sysLog);

    int addNewLoginLog(SysLog sysLog);

    List<SysLog> findSysLogList();

    List<SysLog> findLoginLogList();
}
