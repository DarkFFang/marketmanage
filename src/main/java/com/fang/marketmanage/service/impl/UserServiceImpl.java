package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.UserMapper;
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
    //系统管理员


    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        User user=userMapper.findUserByPhone(phone);
        if(user == null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+(user.getRoleId()).toString()));
        System.out.println(user);
        return new org.springframework.security.core.userdetails.User(user.getPhone(), user.getPassword(), simpleGrantedAuthorities);
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
    public int updateUserById(Integer id) {
        return 0;
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
