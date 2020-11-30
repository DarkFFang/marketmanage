package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<Role> findRolesByUserId(Integer id);

    List<Role> findAllRole();

    int addNewRole(Role role);

    int updateRoleById(Role role);

    int deleteRoleById(Integer id);

    int addNewUserRole(Integer userid, Integer roleid);

    int deleteUserRoleByUserId(Integer userid);

}
