package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.GoodType;

import java.util.List;
/**
 * 服务 {@code GoodTypeService} 商品类型表.
 *
 * @author fang
 * @since 2020/12/14
 */
public interface GoodTypeService {

    /**
     * 增加商品类型
     * @param goodType
     * @return
     */
    int addNewGoodType(GoodType goodType);

    /**
     * 商品类型列表
     * @return
     */
    List<GoodType> findGoodTypeList();

}
