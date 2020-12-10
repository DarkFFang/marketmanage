package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysLogMapper {
    int addNewSysLog(SysLog sysLog);
}
