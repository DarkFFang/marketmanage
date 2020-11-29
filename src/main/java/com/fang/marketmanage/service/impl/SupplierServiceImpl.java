package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.SupplierMapper;
import com.fang.marketmanage.entity.Supplier;
import com.fang.marketmanage.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierMapper supplierMapper;

    @Override
    public int addNewSupplier(Supplier supplier) {
        return supplierMapper.addNewSupplier(supplier);
    }

    @Override
    public List<Supplier> findSupplierList() {
        return supplierMapper.findSupplierList();
    }

    @Override
    public int deleteSupplierById(Integer id) {
        return supplierMapper.deleteSupplierById(id);
    }

    @Override
    public int updateSupplierById(Supplier supplier) {
        return supplierMapper.updateSupplierById(supplier);
    }

    @Override
    public Supplier findSupplierByName(String name) {
        return null;
    }

    @Override
    public List<Supplier> findSupplierListByReputation(String reputation) {
        return null;
    }
}
