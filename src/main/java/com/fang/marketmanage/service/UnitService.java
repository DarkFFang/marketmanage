package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.Unit;

import java.util.List;

public interface UnitService {
    int addNewUnit(Unit unit);

    List<Unit> findUnitList();

}
