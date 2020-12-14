package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Unit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 接口 {@code UnitMapper} 商品单位表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Mapper
public interface UnitMapper {

    /**
     * 增加商品单位
     * @param unit
     * @return
     */
    int addNewUnit(Unit unit);

    /**
     * 商品单位列表
     * @return
     */
    List<Unit> findUnitList();

    /**
     * 更新主键自增ID
     */
    void alterAutoIncrement();
}
