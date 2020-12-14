package com.fang.marketmanage.controller;

import com.fang.marketmanage.annotation.CustomLog;
import com.fang.marketmanage.entity.Refund;
import com.fang.marketmanage.service.RefundService;
import com.fang.marketmanage.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 退货控制器
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
public class RefundController {
    /**
     * 退货服务
     */
    @Autowired
    private RefundService refundService;

    /**
     * 查询退货列表
     *
     * @return {@link List<Refund>}
     */
    @GetMapping("/refund")
    @PreAuthorize("hasAuthority('/refund/**;GET')")
    public List<Refund> findRefundList() {
        return refundService.findRefundList();
    }

    /**
     * 添加新的退款
     *
     * @param refund 退款
     * @return {@link RespUtil}
     */
    @PostMapping("/refund")
    @PreAuthorize("hasAuthority('/refund/**;POST')")
    @CustomLog(operation = "添加商品退货")
    public RespUtil addNewRefund(Refund refund) {
        if (refundService.addNewRefund(refund) == 1) {
            return RespUtil.success("添加成功");
        }
        return RespUtil.error("添加失败");
    }

    /**
     * 通过id更新退款
     *
     * @param refund 退款
     * @return {@link RespUtil}
     */
    @PutMapping("/refund")
    @PreAuthorize("hasAuthority('/refund/**;PUT')")
    @CustomLog(operation = "修改商品退货")
    public RespUtil updateRefundById(Refund refund) {
        if (refundService.updateRefundById(refund) == 1) {
            return RespUtil.success("修改成功");
        }
        return RespUtil.error("添加失败");
    }

    /**
     * 通过id删除退款
     *
     * @param id id
     * @return {@link RespUtil}
     */
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
