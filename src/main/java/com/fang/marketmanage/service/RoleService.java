package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.Permission;
import com.fang.marketmanage.entity.vo.PermissionVo;
import com.fang.marketmanage.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRole();

    List<Role> findRolesByUserId(Integer userid);

    int addNewRole(Role role);

    int updateRoleById(Role role);

    int deleteRoleById(Integer id);

    int addNewUserRole(Integer userid, Integer roleid);

    int updateUserRole(Integer userid, Integer roleid);

    int deleteUserRoleByUserId(Integer userid);


    List<Permission> findPermissionsByUserId(Integer id);

    List<PermissionVo> findPermissionsByRoleId(Integer roleid);

    List<PermissionVo> findAllPermissions();

    List<PermissionVo> findMenuByUserId(Integer id);

    int addNewRolePermissions(Integer roleid, Integer[] permissionids);

    int updateRolePermissions(Integer roleid, Integer[] permissionids);

    int deleteRolePermissionByRoleId(Integer roleid);
}
