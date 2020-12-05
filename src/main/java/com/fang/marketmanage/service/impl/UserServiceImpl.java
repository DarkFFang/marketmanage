package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.config.CustomGrantedAuthority;
import com.fang.marketmanage.dao.PermissionMapper;
import com.fang.marketmanage.dao.RoleMapper;
import com.fang.marketmanage.dao.UserMapper;
import com.fang.marketmanage.entity.JwtUser;
import com.fang.marketmanage.entity.Permission;
import com.fang.marketmanage.entity.Role;
import com.fang.marketmanage.entity.User;
import com.fang.marketmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PermissionMapper permissionMapper;


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

    @Override
    public int addNewUser(User user) {
        return userMapper.addNewUser(user);
    }


    @Override
    public List<User> findUserList() {
        return userMapper.findUserList();
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public int updateUserById(User user) {
        return userMapper.updateUserById(user);
    }

    @Override
    public int updateUserRoleById(Integer id) {
        return userMapper.updateUserRoleById(id);
    }

    @Override
    public List<User> findUserByUsername(String username) {
        return null;
    }

    @Override
    public List<User> findClerkList() {
        return null;
    }

    @Override
    public List<User> findKeeperList() {
        return null;
    }

    @Override
    public int addPermissionById() {
        return 0;
    }

    @Override
    public int deletePermissionById() {
        return 0;
    }

    @Override
    public void alterUserAutoIncrement() {
        userMapper.alterUserAutoIncrement();
    }
}
