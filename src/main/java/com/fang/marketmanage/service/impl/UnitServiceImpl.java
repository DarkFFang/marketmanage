package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.UnitMapper;
import com.fang.marketmanage.entity.Unit;
import com.fang.marketmanage.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {
    @Autowired
    private UnitMapper unitMapper;

    @Override
    public int addNewUnit(Unit unit) {
        return unitMapper.addNewUnit(unit);
    }

    @Override
    public List<Unit> findUnitList() {
        return unitMapper.findUnitList();
    }

}
