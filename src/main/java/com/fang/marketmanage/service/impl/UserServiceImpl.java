package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.RoleMapper;
import com.fang.marketmanage.dao.UserMapper;
import com.fang.marketmanage.entity.Role;
import com.fang.marketmanage.entity.User;
import com.fang.marketmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
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


    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        User user=userMapper.findUserByPhone(phone);
        if(user == null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        List<Role> roles=roleMapper.getRolesByUserId(user.getId());
        user.setRoles(roles);
        return user;
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
        return 0;
    }

    @Override
    public int updateUserById(User user) {
        return userMapper.updateUserById(user);
    }

    @Override
    public int updateUserRoleById(Integer id) {
        return 0;
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
}
