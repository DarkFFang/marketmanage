package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.GoodType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 接口 {@code GoodTypeMapper} 商品类型表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Mapper
public interface GoodTypeMapper {
    /**
     * 增加用户类型
     * @param goodType
     * @return
     */
    int addNewGoodType(GoodType goodType);

    /**
     * 商品类型列表
     * @return
     */
    List<GoodType> findGoodTypeList();

    /**
     * 更新主键自增ID
     */
    void alterAutoIncrement();
}
