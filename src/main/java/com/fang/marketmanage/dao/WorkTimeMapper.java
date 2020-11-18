package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.WorkTime;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkTimeMapper {
    int addNewWorkTime(WorkTime worktime);//增加时间表项

    int deleteWorkTimeById(Integer id);//删除时间表项

    WorkTime updateWorkTimeById(Integer id);//修改时间表项

    List<WorkTime> findWorkTimeList();//时间表列表

    List<WorkTime> searchWorkTimeByUsername(String username);//通过姓名查询时间表列表

    List<WorkTime> findClerkTime();//查询营业员时间表列表

    List<WorkTime> findKeeperTime();//查询库管员时间表列表
}
