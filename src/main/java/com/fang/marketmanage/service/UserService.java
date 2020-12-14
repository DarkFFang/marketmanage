package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.User;
import com.fang.marketmanage.entity.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
/**
 * 服务 {@code UserService} 用户表.
 *
 * @author fang
 * @since 2020/12/14
 */
public interface UserService extends UserDetailsService {

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
     * 通过id查找
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
     */
    //List<Permission> findPermissionById();
}
