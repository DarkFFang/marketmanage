package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.Permission;
import com.fang.marketmanage.entity.vo.PermissionVo;
import com.fang.marketmanage.entity.Role;

import java.util.List;
/**
 * 服务 {@code RoleService} 角色表.
 *
 * @author fang
 * @since 2020/12/14
 */
public interface RoleService {

    /**
     * 角色列表
     * @return
     */
    List<Role> findAllRole();

    /**
     * 通过用户编号查询角色
     * @param userid
     * @return
     */
    List<Role> findRolesByUserId(Integer userid);

    /**
     * 增加角色
     * @param role
     * @return
     */
    int addNewRole(Role role);

    /**
     * 修改角色
     * @param role
     * @return
     */
    int updateRoleById(Role role);

    /**
     * 删除角色
     * @param id
     * @return
     */
    int deleteRoleById(Integer id);

    /**
     * 增加用户角色
     * @param userid
     * @param roleid
     * @return
     */
    int addNewUserRole(Integer userid, Integer roleid);

    /**
     * 修改用户角色
     * @param userid
     * @param roleid
     * @return
     */
    int updateUserRole(Integer userid, Integer roleid);

    /**
     * 删除用户角色
     * @param userid
     * @return
     */
    int deleteUserRoleByUserId(Integer userid);

    /**
     * 通过用户编号查找权限
     * @param id
     * @return
     */
    List<Permission> findPermissionsByUserId(Integer id);

    /**
     * 通过角色编号查询权限
     * @param roleid
     * @return
     */
    List<PermissionVo> findPermissionsByRoleId(Integer roleid);

    /**
     * 所有权限列表
     * @return
     */
    List<PermissionVo> findAllPermissions();

    /**
     * 通过用户编号查询菜单
     * @param id
     * @return
     */
    List<PermissionVo> findMenuByUserId(Integer id);

    /**
     * 增加角色权限
     * @param roleid
     * @param permissionids
     * @return
     */
    int addNewRolePermissions(Integer roleid, Integer[] permissionids);

    /**
     * 修改角色权限
     * @param roleid
     * @param permissionids
     * @return
     */
    int updateRolePermissions(Integer roleid, Integer[] permissionids);

    /**
     * 删除角色权限
     * @param roleid
     * @return
     */
    int deleteRolePermissionByRoleId(Integer roleid);
}
