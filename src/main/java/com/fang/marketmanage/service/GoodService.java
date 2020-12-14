package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.Good;

import java.util.List;
/**
 * 服务 {@code GoodService} 商品表.
 *
 * @author fang
 * @since 2020/12/14
 */
public interface GoodService {

    /**
     * 增加商品
     * @param good
     * @return
     */
    int addNewGood(Good good);

    /**
     * 商品列表
     * @return
     */
    List<Good> findGoodList();

    /**
     * 删除商品
     * @param id
     * @return
     */
    int deleteGoodById(Integer id);

    /**
     * 修改商品
     * @param good
     * @return
     */
    int updateGoodById(Good good);

    /**
     * 通过商品名称查询商品
     * @param name
     * @return
     */
    Good findGoodByName(String name);

    /**
     * 通过商品类型查询商品列表
     * @param name
     * @return
     */
    List<Good> findGoodListByType(String name);

    /**
     * 更新主键自增ID
     */
    void alterGoodAutoIncrement();
}
