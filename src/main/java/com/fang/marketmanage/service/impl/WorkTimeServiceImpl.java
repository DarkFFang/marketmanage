package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.WorkTimeMapper;
import com.fang.marketmanage.entity.WorkTime;
import com.fang.marketmanage.service.WorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTimeServiceImpl implements WorkTimeService {
    @Autowired
    private WorkTimeMapper workTimeMapper;

    @Override
    public int addNewWorkTime(WorkTime worktime){return workTimeMapper.addNewWorkTime(worktime);};

    @Override
    public int deleteWorkTimeById(Integer id){return workTimeMapper.deleteWorkTimeById(id);};

    @Override
    public int updateWorkTimeById(WorkTime worktime){return workTimeMapper.updateWorkTimeById(worktime);};

    @Override
    public List<WorkTime> findWorkTimeList(){return workTimeMapper.findWorkTimeList();};

    @Override
    public List<WorkTime> searchWorkTimeByUsername(String username){return null;};

    @Override
    public List<WorkTime> findClerkTime(){return null;};

    @Override
    public List<WorkTime> findKeeperTime(){return null;};

}
