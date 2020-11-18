package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Refund;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface RefundMapper {
    int addNewRefund(Refund good);//增加退货表项

    List<Refund> findRefundList();//退货列表

    int deleteRefundById(Integer id);//删除退货表项

    Refund updateRefundById(Integer id);//修改退货表项

    List<Refund> findRefundListByName(String name);//通过商品名称查询退货列表

    List<Refund> findRefundListByDate(Date date);//通过退货时间查询退货列表
}
