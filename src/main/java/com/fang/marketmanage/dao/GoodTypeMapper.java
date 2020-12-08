package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.GoodType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodTypeMapper {
    int addNewGoodType(GoodType goodType);

    List<GoodType> findGoodTypeList();

    void alterAutoIncrement();
}
