package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.Refund;

import java.util.Date;
import java.util.List;
/**
 * 服务 {@code RefundService} 商品退货表.
 *
 * @author fang
 * @since 2020/12/14
 */
public interface RefundService {

    /**
     * 增加退货表项
     * @param refund
     * @return
     */
    int addNewRefund(Refund refund);

    /**
     * 退货列表
     * @return
     */
    List<Refund> findRefundList();

    /**
     * 删除退货表项
     * @param id
     * @return
     */
    int deleteRefundById(Integer id);

    /**
     * 修改退货表项
     * @param refund
     * @return
     */
    int updateRefundById(Refund refund);

    /**
     * 通过商品名称查询退货列表
     * @param name
     * @return
     */
    List<Refund> findRefundListByName(String name);

    /**
     * 通过退货时间查询退货列表
     * @param date
     * @return
     */
    List<Refund> findRefundListByDate(Date date);

}
