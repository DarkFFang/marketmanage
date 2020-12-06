package com.fang.marketmanage.controller;
import com.fang.marketmanage.entity.Supplier;
import com.fang.marketmanage.service.SupplierService;
import com.fang.marketmanage.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @GetMapping("/supplier")
    @PreAuthorize("hasAuthority('/supplier/**;GET')")
    public List<Supplier> findSupplierList() {
        return supplierService.findSupplierList();
    }
    @PostMapping("/supplier")
    @PreAuthorize("hasAuthority('/supplier/**;POST')")
    public RespUtil addNewSupplier(Supplier supplier) {
        if (supplierService.addNewSupplier(supplier) == 1) {
            return RespUtil.success("添加成功！");
        } else {
            return RespUtil.error("添加失败！");
        }
    }
    @DeleteMapping("/supplier/{id}")
    @PreAuthorize("hasAuthority('/supplier/**;DELETE')")
    public RespUtil deleteSupplierById(@PathVariable Integer id) {
        if (supplierService.deleteSupplierById(id) == 1) {
            return RespUtil.success("删除成功！");
        } else {
            return RespUtil.error("删除失败！");
        }
    }
    @PutMapping("/supplier")
    @PreAuthorize("hasAuthority('/supplier/**;PUT')")
    public RespUtil updateSupplierById(Supplier supplier) {
        if (supplierService.updateSupplierById(supplier) == 1) {
            return RespUtil.success("修改成功！");
        } else {
            return RespUtil.error("修改失败！");
        }
    }
}
