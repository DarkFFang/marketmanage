package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.SysLogMapper;
import com.fang.marketmanage.entity.SysLog;
import com.fang.marketmanage.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;
    @Override
    public int addNewSysLog(SysLog sysLog) {
        return sysLogMapper.addNewSysLog(sysLog);
    }
}
