package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.SysLog;

import java.util.List;
/**
 * 服务 {@code SysLogService} 日志表.
 *
 * @author fang
 * @since 2020/12/14
 */
public interface SysLogService {

    /**
     * 增加系统日志
     * @param sysLog
     * @return
     */
    int addNewSysLog(SysLog sysLog);

    /**
     * 增加登录日志
     * @param sysLog
     * @return
     */
    int addNewLoginLog(SysLog sysLog);

    /**
     * 系统日志列表
     * @return
     */
    List<SysLog> findSysLogList();

    /**
     * 登录日志列表
     * @return
     */
    List<SysLog> findLoginLogList();
}
