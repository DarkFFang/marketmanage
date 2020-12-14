package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.Unit;

import java.util.List;
/**
 * 服务 {@code UnitService} 商品单位表.
 *
 * @author fang
 * @since 2020/12/14
 */
public interface UnitService {

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

}
