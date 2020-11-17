package com.fang.marketmanage.dao;

import java.util.List;

public interface WorkTimeMapper {
    int addWorkTime(WorkTimeMapper worktime);//增加时间表项
    int daleteWorkTime(WorkTimeMapper worktime);//删除时间表项
    WorkTimeMapper updateWorkTime();//修改时间表项
    List<WorkTimeMapper> finWorkTimeList();//时间表列表
    WorkTimeMapper searchWorkTimeByName(String username);//通过姓名查询时间表
    List<WorkTimeMapper> searchClerkTime();//查询营业员时间表列表
    List<WorkTimeMapper> searchKeeperTime();//查询库管员时间表列表
}
