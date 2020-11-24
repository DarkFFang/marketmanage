package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<Role> getRolesByUserId(Integer id);
    List<Role> getRolesList();
}
