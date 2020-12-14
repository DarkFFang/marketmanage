package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.SysLogMapper;
import com.fang.marketmanage.entity.SysLog;
import com.fang.marketmanage.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统日志服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@Service
public class SysLogServiceImpl implements SysLogService {
    /**
     * 系统日志映射器
     */
    @Autowired
    private SysLogMapper sysLogMapper;

    /**
     * 添加新系统日志
     *
     * @param sysLog 系统日志
     * @return int
     */
    @Override
    public int addNewSysLog(SysLog sysLog) {
        return sysLogMapper.addNewSysLog(sysLog);
    }

    /**
     * 添加新的登录日志
     *
     * @param sysLog 系统日志
     * @return int
     */
    @Override
    public int addNewLoginLog(SysLog sysLog) {
        return sysLogMapper.addNewLoginLog(sysLog);
    }

    /**
     * 系统日志列表
     *
     * @return {@link List<SysLog>}
     */
    @Override
    public List<SysLog> findSysLogList() {
        return sysLogMapper.findSysLogList();
    }

    /**
     * 登录日志列表
     *
     * @return {@link List<SysLog>}
     */
    @Override
    public List<SysLog> findLoginLogList() {
        return sysLogMapper.findLoginLogList();
    }
}
