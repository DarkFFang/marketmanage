package com.fang.marketmanage.controller;
import com.fang.marketmanage.annotation.CustomLog;
import com.fang.marketmanage.entity.Supplier;
import com.fang.marketmanage.service.SupplierService;
import com.fang.marketmanage.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 供应商控制器
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
public class SupplierController {
    /**
     * 供应商服务
     */
    @Autowired
    SupplierService supplierService;

    /**
     * 查找供应商列表
     *
     * @return {@link List<Supplier>}
     */
    @GetMapping("/supplier")
    @PreAuthorize("hasAuthority('/supplier/**;GET')")
    public List<Supplier> findSupplierList() {
        return supplierService.findSupplierList();
    }

    /**
     * 增加新的供应商
     *
     * @param supplier 供应商
     * @return {@link RespUtil}
     */
    @PostMapping("/supplier")
    @PreAuthorize("hasAuthority('/supplier/**;POST')")
    @CustomLog(operation = "添加供应商")
    public RespUtil addNewSupplier(Supplier supplier) {
        if (supplierService.addNewSupplier(supplier) == 1) {
            return RespUtil.success("添加成功！");
        } else {
            return RespUtil.error("添加失败！");
        }
    }

    /**
     * 通过id删除供应商
     *
     * @param id id
     * @return {@link RespUtil}
     */
    @DeleteMapping("/supplier/{id}")
    @PreAuthorize("hasAuthority('/supplier/**;DELETE')")
    @CustomLog(operation = "删除供应商")
    public RespUtil deleteSupplierById(@PathVariable Integer id) {
        if (supplierService.deleteSupplierById(id) == 1) {
            return RespUtil.success("删除成功！");
        } else {
            return RespUtil.error("删除失败！");
        }
    }

    /**
     * 通过id更新供应商
     *
     * @param supplier 供应商
     * @return {@link RespUtil}
     */
    @PutMapping("/supplier")
    @PreAuthorize("hasAuthority('/supplier/**;PUT')")
    @CustomLog(operation = "修改供应商")
    public RespUtil updateSupplierById(Supplier supplier) {
        if (supplierService.updateSupplierById(supplier) == 1) {
            return RespUtil.success("修改成功！");
        } else {
            return RespUtil.error("修改失败！");
        }
    }
}
