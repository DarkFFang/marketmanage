package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.RefundMapper;
import com.fang.marketmanage.dao.StockMapper;
import com.fang.marketmanage.entity.Refund;
import com.fang.marketmanage.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * impl退货服务
 *
 * @author fang
 * @date 2020/12/14
 */
@Service
public class RefundServiceImpl implements RefundService {
    /**
     * 退货映射器
     */
    @Autowired
    private RefundMapper refundMapper;
    /**
     * 库存映射器
     */
    @Autowired
    private StockMapper stockMapper;


    /**
     * 添加新的退货表项
     *
     * @param refund 退货
     * @return int
     */
    @Override
    public int addNewRefund(Refund refund) {
        stockMapper.updateStockQuantityIncByGoodId(refund.getQuantity(), refund.getGoodId());
        refund.setDate(new Date());
        return refundMapper.addNewRefund(refund);
    }

    /**
     * 退货列表
     *
     * @return {@link List<Refund>}
     */
    @Override
    public List<Refund> findRefundList() {
        return refundMapper.findRefundList();
    }

    /**
     * 通过id删除退货表项
     *
     * @param id id
     * @return int
     */
    @Override
    public int deleteRefundById(Integer id) {
        return refundMapper.deleteRefundById(id);
    }

    /**
     * 通过id更新退货表项
     *
     * @param refund 退货
     * @return int
     */
    @Override
    public int updateRefundById(Refund refund) {
        return refundMapper.updateRefundById(refund);
    }

    /**
     * 通过商品名称查找退货表
     *
     * @param name 名字
     * @return {@link List<Refund>}
     */
    @Override
    public List<Refund> findRefundListByName(String name) {
        return null;
    }

    /**
     * 按日期查找退货表
     *
     * @param date 日期
     * @return {@link List<Refund>}
     */
    @Override
    public List<Refund> findRefundListByDate(Date date) {
        return null;
    }
}
