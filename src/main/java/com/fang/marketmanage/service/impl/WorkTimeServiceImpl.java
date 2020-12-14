package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.WorkTimeMapper;
import com.fang.marketmanage.entity.WorkTime;
import com.fang.marketmanage.service.WorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 工作时间服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@Service
public class WorkTimeServiceImpl implements WorkTimeService {
    /**
     * 工作时间映射器
     */
    @Autowired
    private WorkTimeMapper workTimeMapper;

    /**
     * 添加新的工作时间
     *
     * @param worktime 想出
     * @return int
     */
    @Override
    public int addNewWorkTime(WorkTime worktime){return workTimeMapper.addNewWorkTime(worktime);};

    /**
     * 通过id删除工作时间
     *
     * @param id id
     * @return int
     */
    @Override
    public int deleteWorkTimeById(Integer id){return workTimeMapper.deleteWorkTimeById(id);};

    /**
     * 通过id更新工作时间
     *
     * @param worktime 工作时间
     * @return int
     */
    @Override
    public int updateWorkTimeById(WorkTime worktime){return workTimeMapper.updateWorkTimeById(worktime);};

    /**
     * 工作时间列表
     *
     * @return {@link List<WorkTime>}
     */
    @Override
    public List<WorkTime> findWorkTimeList(){return workTimeMapper.findWorkTimeList();};

    /**
     * 按用户名搜索工作时间
     *
     * @param username 用户名
     * @return {@link List<WorkTime>}
     */
    @Override
    public List<WorkTime> searchWorkTimeByUsername(String username){return null;};

    /**
     * 营业员工作时间列表
     *
     * @return {@link List<WorkTime>}
     */
    @Override
    public List<WorkTime> findClerkTime(){return null;};

    /**
     * 库管员工作时间列表
     *
     * @return {@link List<WorkTime>}
     */
    @Override
    public List<WorkTime> findKeeperTime(){return null;};

}
