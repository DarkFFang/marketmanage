package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
    public List<Permission> findPermissionsByUserId(Integer id);

    public List<Permission> findAll();
}
