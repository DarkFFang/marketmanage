package com.fang.marketmanage.controller;

import com.fang.marketmanage.annotation.CustomLog;
import com.fang.marketmanage.entity.Refund;
import com.fang.marketmanage.service.RefundService;
import com.fang.marketmanage.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RefundController {
    @Autowired
    private RefundService refundService;

    @GetMapping("/refund")
    @PreAuthorize("hasAuthority('/refund/**;GET')")
    public List<Refund> findRefundList() {
        return refundService.findRefundList();
    }

    @PostMapping("/refund")
    @PreAuthorize("hasAuthority('/refund/**;POST')")
    @CustomLog(operation = "添加商品退货")
    public RespUtil addNewRefund(Refund refund) {
        if (refundService.addNewRefund(refund) == 1) {
            return RespUtil.success("添加成功");
        }
        return RespUtil.error("添加失败");
    }

    @PutMapping("/refund")
    @PreAuthorize("hasAuthority('/refund/**;PUT')")
    @CustomLog(operation = "修改商品退货")
    public RespUtil updateRefundById(Refund refund) {
        if (refundService.updateRefundById(refund) == 1) {
            return RespUtil.success("修改成功");
        }
        return RespUtil.error("添加失败");
    }

    @DeleteMapping("/refund/{id}")
    @PreAuthorize("hasAuthority('/refund/**;DELETE')")
    @CustomLog(operation = "删除商品退货")
    public RespUtil deleteRefundById(@PathVariable Integer id) {
        if (refundService.deleteRefundById(id) == 1) {
            return RespUtil.success("删除成功");
        }
        return RespUtil.error("删除失败");
    }
}
