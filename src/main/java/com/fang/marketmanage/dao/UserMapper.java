package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Role;
import com.fang.marketmanage.entity.User;
import com.fang.marketmanage.entity.vo.UserVo;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 接口 {@code UserMapper} 用户表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Mapper
public interface UserMapper {

    /**
     * 增加用户（营业员或库管员）
     * @param user
     * @return
     */
    int addNewUser(User user);

    /**
     * 用户列表（营业员和库管员）
     * @return
     */
    List<UserVo> findUserList();

    /**
     * 通过id查找用户
     * @param id
     * @return
     */
    User findUserById(Integer id);

    /**
     * 删除用户（营业员或库管员）
     * @param id
     * @return
     */
    int deleteUserById(Integer id);

    /**
     * 修改用户（营业员或库管员）
     * @param user
     * @return
     */
    int updateUserById(User user);

    /**
     * 修改用户（营业员或库管员）
     * @param id
     * @return
     */
    int updateUserRoleById(Integer id);

    /**
     * 通过用户名（营业员或库管员）查询用户
     * @param username
     * @return
     */
    List<User> findUserByUsername(String username);

    /**
     * 通过电话查找用户
     * @param phone
     * @return
     */
    User findUserByPhone(String phone);

    /**
     * 搜索营业员列表
     * @return
     */
    List<User> findClerkList();

    /**
     * 搜索库管员列表
     * @return
     */
    List<User> findKeeperList();

    /**
     * 增加用户权限
     * @return
     */
    int addPermissionById();

    /**
     * 删除用户权限
     * @return
     */
    int deletePermissionById();

    /**
     * 查询用户权限
     * @return
     */
    int findPermissionById();

    /**
     * 更新主键自增ID
     */
    void alterUserAutoIncrement();

}
