package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 接口 {@code SupplierMapper} 供应商表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Mapper
public interface SupplierMapper {

    /**
     * 增加供应商
     * @param supplier
     * @return
     */
    int addNewSupplier(Supplier supplier);

    /**
     * 供应商列表
     * @return
     */
    List<Supplier> findSupplierList();

    /**
     * 删除供应商
     * @param id
     * @return
     */
    int deleteSupplierById(Integer id);

    /**
     * 修改供应商
     * @param supplier
     * @return
     */
    int updateSupplierById(Supplier supplier);

    /**
     * 通过供应商名称查询供应商
     * @param name
     * @return
     */
    Supplier findSupplierByName(String name);

    /**
     * 通过名誉查询供应商列表
     * @param reputation
     * @return
     */
    List<Supplier> findSupplierListByReputation(String reputation);
}
