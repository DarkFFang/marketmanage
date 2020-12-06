package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.RefundMapper;
import com.fang.marketmanage.dao.StockMapper;
import com.fang.marketmanage.entity.Refund;
import com.fang.marketmanage.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RefundServiceImpl implements RefundService {
    @Autowired
    private RefundMapper refundMapper;
    @Autowired
    private StockMapper stockMapper;


    @Override
    public int addNewRefund(Refund refund) {
        stockMapper.updateStockQuantityIncByGoodId(refund.getQuantity(), refund.getGoodId());
        refund.setDate(new Date());
        return refundMapper.addNewRefund(refund);
    }

    @Override
    public List<Refund> findRefundList() {
        return refundMapper.findRefundList();
    }

    @Override
    public int deleteRefundById(Integer id) {
        return refundMapper.deleteRefundById(id);
    }

    @Override
    public int updateRefundById(Refund refund) {
        return refundMapper.updateRefundById(refund);
    }

    @Override
    public List<Refund> findRefundListByName(String name) {
        return null;
    }

    @Override
    public List<Refund> findRefundListByDate(Date date) {
        return null;
    }
}
