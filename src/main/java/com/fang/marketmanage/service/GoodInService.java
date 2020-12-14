package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.GoodIn;

import java.util.Date;
import java.util.List;
/**
 * 服务 {@code GoodInService} 商品入库表.
 *
 * @author fang
 * @since 2020/12/14
 */
public interface GoodInService {

    /**
     * 添加入库单
     * @param goodIn
     * @return
     */
    int addNewGoodIn(GoodIn goodIn);

    /**
     * 入库单列表
     * @return
     */
    List<GoodIn> findGoodInList();

    /**
     * 删除入库表一项
     * @param id
     * @return
     */
    int deleteGoodInById(Integer id);

    /**
     * 修改入库单信息
     * @param goodIn
     * @return
     */
    int updateGoodInById(GoodIn goodIn);

    /**
     * 通过商品名称查询入库单列表
     * @param name
     * @return
     */
    List<GoodIn> findGoodInListByName(String name);

    /**
     * 通过时间查询入库单列表
     * @param date
     * @return
     */
    List<GoodIn> findGoodInListByDate(Date date);

    /**
     * 通过库管员姓名查询入库单列表
     * @param name
     * @return
     */
    List<GoodIn> findGoodInListByClerkName(String name);

}
