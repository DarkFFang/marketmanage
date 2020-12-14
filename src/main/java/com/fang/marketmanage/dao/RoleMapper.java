package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 接口 {@code RoleMapper} 角色表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Mapper
public interface RoleMapper {

    /**
     * 通过用户编号查询用户权限
     * @param id
     * @return
     */
    List<Role> findRolesByUserId(Integer id);

    /**
     * 查询所有权限列表
     * @return
     */
    List<Role> findAllRole();

    /**
     * 添加新角色
     * @param role
     * @return
     */
    int addNewRole(Role role);

    /**
     * 修改角色权限
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
     * 添加角色权限
     * @param userid
     * @param roleid
     * @return
     */
    int addNewUserRole(Integer userid, Integer roleid);

    /**
     * 删除角色权限
     * @param userid
     * @return
     */
    int deleteUserRoleByUserId(Integer userid);

}
