package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.SupplierMapper;
import com.fang.marketmanage.entity.Supplier;
import com.fang.marketmanage.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 供应商服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@Service
public class SupplierServiceImpl implements SupplierService {
    /**
     * 供应商映射器
     */
    @Autowired
    SupplierMapper supplierMapper;

    /**
     * 增加新的供应商
     *
     * @param supplier 供应商
     * @return int
     */
    @Override
    public int addNewSupplier(Supplier supplier) {
        return supplierMapper.addNewSupplier(supplier);
    }

    /**
     * 供应商列表
     *
     * @return {@link List<Supplier>}
     */
    @Override
    public List<Supplier> findSupplierList() {
        return supplierMapper.findSupplierList();
    }

    /**
     * 通过id删除供应商
     *
     * @param id id
     * @return int
     */
    @Override
    public int deleteSupplierById(Integer id) {
        return supplierMapper.deleteSupplierById(id);
    }

    /**
     * 通过id更新供应商
     *
     * @param supplier 供应商
     * @return int
     */
    @Override
    public int updateSupplierById(Supplier supplier) {
        return supplierMapper.updateSupplierById(supplier);
    }

    /**
     * 通过供应商名称查询供应商
     *
     * @param name 名字
     * @return {@link Supplier}
     */
    @Override
    public Supplier findSupplierByName(String name) {
        return null;
    }

    /**
     * 通过声誉查找供应商
     *
     * @param reputation 声誉
     * @return {@link List<Supplier>}
     */
    @Override
    public List<Supplier> findSupplierListByReputation(String reputation) {
        return null;
    }
}
