package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Permission;
import com.fang.marketmanage.entity.PermissionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
    List<Permission> findPermissionsByUserId(Integer id);

    List<PermissionVo> findPermissionsByRoleId(Integer id);

    List<PermissionVo> findAllPermissions();

    int addNewRolePermissions(Integer roleid,Integer[] permissionids);

    int deleteRolePermissionByRoleId(Integer roleid);
}
