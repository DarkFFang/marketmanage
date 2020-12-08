package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Unit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UnitMapper {
    int addNewUnit(Unit unit);

    List<Unit> findUnitList();

    void alterAutoIncrement();
}
