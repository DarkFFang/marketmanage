package com.fang.marketmanage.controller;
import com.fang.marketmanage.entity.Supplier;
import com.fang.marketmanage.service.SupplierService;
import com.fang.marketmanage.util.Resp;
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
    public Resp addNewSupplier(Supplier supplier) {
        if (supplierService.addNewSupplier(supplier) == 1) {
            return Resp.success("添加成功！");
        } else {
            return Resp.error("添加失败！");
        }
    }
    @DeleteMapping("/supplier/{id}")
    @PreAuthorize("hasAuthority('/supplier/**;DELETE')")
    public Resp deleteSupplierById(@PathVariable Integer id) {
        if (supplierService.deleteSupplierById(id) == 1) {
            return Resp.success("删除成功！");
        } else {
            return Resp.error("删除失败！");
        }
    }
    @PutMapping("/supplier")
    @PreAuthorize("hasAuthority('/supplier/**;PUT')")
    public Resp updateSupplierById(Supplier supplier) {
        if (supplierService.updateSupplierById(supplier) == 1) {
            return Resp.success("修改成功！");
        } else {
            return Resp.error("修改失败！");
        }
    }
    @GetMapping("/supplier")
    @PreAuthorize("hasAuthority('/supplier/**;GET')")
    public Supplier findSupplierByName(String name) {
        return supplierService.findSupplierByName(name);
    }
    @GetMapping("/supplier")
    @PreAuthorize("hasAuthority('/supplier/**;GET')")
    public List<Supplier> findSupplierListByReputation(String reputation) {
        return supplierService.findSupplierListByReputation(reputation);
    }
}
