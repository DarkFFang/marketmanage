package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.PermissionMapper;
import com.fang.marketmanage.dao.RoleMapper;
import com.fang.marketmanage.entity.Permission;
import com.fang.marketmanage.entity.vo.PermissionVo;
import com.fang.marketmanage.entity.Role;
import com.fang.marketmanage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Role> findAllRole() {
        return roleMapper.findAllRole();
    }

    @Override
    public List<Role> findRolesByUserId(Integer id) {
        return roleMapper.findRolesByUserId(id);
    }

    @Override
    public int addNewRole(Role role) {
        return roleMapper.addNewRole(role);
    }

    @Override
    public int updateRoleById(Role role) {
        return roleMapper.updateRoleById(role);
    }

    @Override
    public int deleteRoleById(Integer id) {
        return roleMapper.deleteRoleById(id);
    }

    @Override
    public int updateUserRole(Integer userid, Integer roleid) {
        roleMapper.deleteUserRoleByUserId(userid);
        return roleMapper.addNewUserRole(userid, roleid);
    }


    @Override
    public int addNewUserRole(Integer userid, Integer roleid) {
        return roleMapper.addNewUserRole(userid, roleid);
    }

    @Override
    public int deleteUserRoleByUserId(Integer userid) {
        return roleMapper.deleteUserRoleByUserId(userid);
    }

    @Override
    public List<Permission> findPermissionsByUserId(Integer id) {
        return permissionMapper.findPermissionsByUserId(id);
    }

    @Override
    public List<PermissionVo> findPermissionsByRoleId(Integer roleid) {
        return permissionMapper.findPermissionsByRoleId(roleid);
    }

    @Override
    public List<PermissionVo> findMenuByUserId(Integer id) {
        return permissionMapper.findMenuByUserId(id);
    }

    @Override
    public List<PermissionVo> findAllPermissions() {
        return permissionMapper.findAllPermissions();
    }

    @Override
    public int addNewRolePermissions(Integer roleid, Integer[] permissionids) {
        return permissionMapper.addNewRolePermissions(roleid, permissionids);
    }

    @Override
    public int updateRolePermissions(Integer roleid, Integer[] permissionids) {
        permissionMapper.deleteRolePermissionByRoleId(roleid);
        return permissionMapper.addNewRolePermissions(roleid, permissionids);
    }

    @Override
    public int deleteRolePermissionByRoleId(Integer roleid) {
        return permissionMapper.deleteRolePermissionByRoleId(roleid);
    }
}
