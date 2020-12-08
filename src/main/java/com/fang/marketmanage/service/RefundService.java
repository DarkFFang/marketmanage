package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.Refund;

import java.util.Date;
import java.util.List;

public interface RefundService {
    int addNewRefund(Refund refund); //增加退货表项

    List<Refund> findRefundList(); //退货列表

    int deleteRefundById(Integer id); //删除退货表项

    int updateRefundById(Refund refund); //修改退货表项

    List<Refund> findRefundListByName(String name); //通过商品名称查询退货列表

    List<Refund> findRefundListByDate(Date date); //通过退货时间查询退货列表

}
