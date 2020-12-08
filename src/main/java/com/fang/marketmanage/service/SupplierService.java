package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.Supplier;

import java.util.List;

public interface SupplierService {
    int addNewSupplier(Supplier supplier); //增加供应商

    List<Supplier> findSupplierList(); //供应商列表

    int deleteSupplierById(Integer id); //删除供应商

    int updateSupplierById(Supplier supplier); //修改供应商

    Supplier findSupplierByName(String name); //通过供应商名称查询供应商

    List<Supplier> findSupplierListByReputation(String reputation); //通过名誉查询供应商列表
}
