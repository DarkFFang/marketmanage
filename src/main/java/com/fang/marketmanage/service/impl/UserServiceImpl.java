package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.config.CustomGrantedAuthority;
import com.fang.marketmanage.dao.PermissionMapper;
import com.fang.marketmanage.dao.RoleMapper;
import com.fang.marketmanage.dao.UserMapper;
import com.fang.marketmanage.entity.JwtUser;
import com.fang.marketmanage.entity.Permission;
import com.fang.marketmanage.entity.User;
import com.fang.marketmanage.entity.vo.UserVo;
import com.fang.marketmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务impl
 *
 * @author fang
 * @date 2020/12/14
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 用户映射器
     */
    @Autowired
    UserMapper userMapper;

    /**
     * 角色映射器
     */
    @Autowired
    RoleMapper roleMapper;

    /**
     * 许可映射器
     */
    @Autowired
    PermissionMapper permissionMapper;


    /**
     * 加载用户的用户名
     *
     * @param phone 电话
     * @return {@link UserDetails}* @throws UsernameNotFoundException 用户名没有发现异常
     */
    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        User user=userMapper.findUserByPhone(phone);
        if(user == null){
            throw new UsernameNotFoundException(phone+"用户不存在！请联系管理员。");
        }
        List<Permission> permissions=permissionMapper.findPermissionsByUserId(user.getId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Permission permission : permissions) {
            if (permission != null && permission.getName() != null) {
                GrantedAuthority grantedAuthority = new CustomGrantedAuthority(permission.getUrl(), permission.getMethod());
                authorities.add(grantedAuthority);
            }
        }
        return new JwtUser(user.getId(),user.getUsername(),user.getPhone(),user.getPassword(),authorities);
    }

    /**
     * 添加新用户
     *
     * @param user 用户
     * @return int
     */
    @Override
    public int addNewUser(User user) {
        return userMapper.addNewUser(user);
    }


    /**
     * 用户列表
     *
     * @return {@link List<UserVo>}
     */
    @Override
    public List<UserVo> findUserList() {
        return userMapper.findUserList();
    }

    /**
     * 通过id查询用户
     *
     * @param id id
     * @return {@link User}
     */
    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    /**
     * 通过id删除用户
     *
     * @param id id
     * @return int
     */
    @Override
    public int deleteUserById(Integer id) {
        int result=userMapper.deleteUserById(id);
        if (result == 1) {
            userMapper.alterUserAutoIncrement();
        }
        return result;
    }

    /**
     * 通过id更新用户
     *
     * @param user 用户
     * @return int
     */
    @Override
    public int updateUserById(User user) {
        return userMapper.updateUserById(user);
    }

    /**
     * 通过id更新用户角色
     *
     * @param id id
     * @return int
     */
    @Override
    public int updateUserRoleById(Integer id) {
        return userMapper.updateUserRoleById(id);
    }

    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return {@link List<User>}
     */
    @Override
    public List<User> findUserByUsername(String username) {
        return null;
    }

    /**
     * 营业员列表
     *
     * @return {@link List<User>}
     */
    @Override
    public List<User> findClerkList() {
        return null;
    }

    /**
     * 库管员列表
     *
     * @return {@link List<User>}
     */
    @Override
    public List<User> findKeeperList() {
        return null;
    }

    /**
     * 通过id添加权限
     *
     * @return int
     */
    @Override
    public int addPermissionById() {
        return 0;
    }

    /**
     * 通过id删除权限
     *
     * @return int
     */
    @Override
    public int deletePermissionById() {
        return 0;
    }

}
