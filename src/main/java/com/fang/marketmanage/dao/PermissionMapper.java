package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Permission;
import com.fang.marketmanage.entity.vo.PermissionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 接口 {@code PermissionMapper} 权限表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Mapper
public interface PermissionMapper {

    /**
     * 通过用户编号查询权限
     * @param id
     * @return
     */
    List<Permission> findPermissionsByUserId(Integer id);

    /**
     * 通过角色编号查询权限
     * @param id
     * @return
     */
    List<PermissionVo> findPermissionsByRoleId(Integer id);

    /**
     * 权限列表
     * @return
     */
    List<PermissionVo> findAllPermissions();

    /**
     * 通过用户编号查询用户菜单
     * @param id
     * @return
     */
    List<PermissionVo> findMenuByUserId(Integer id);

    /**
     * 添加角色权限
     * @param roleid
     * @param permissionids
     * @return
     */
    int addNewRolePermissions(Integer roleid, Integer[] permissionids);

    /**
     * 通过角色编号删除角色权限
     * @param roleid
     * @return
     */
    int deleteRolePermissionByRoleId(Integer roleid);
}
