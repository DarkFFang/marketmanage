package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysLogMapper {
    int addNewSysLog(SysLog sysLog);

    int addNewLoginLog(SysLog sysLog);

    List<SysLog> findSysLogList();

    List<SysLog> findLoginLogList();
}
