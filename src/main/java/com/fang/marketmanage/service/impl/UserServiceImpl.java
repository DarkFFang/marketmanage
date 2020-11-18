package com.fang.marketmanage.service.impl;

import com.fang.marketmanage.dao.UserMapper;
import com.fang.marketmanage.entity.User;
import com.fang.marketmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    //系统管理员
    @Override
    public int addNewUser(User user) {
        return userMapper.addNewUser(user);
    }


    @Override
    public List<User> findUserList() {
        return userMapper.findUserList();
    }

    @Override
    public User update(Integer id) {
        return null;
    }

    @Override
    public User exit() {
        return null;
    }

    @Override
    public User register(User user) {
        return null;
    }

    @Override
    public int deleteUserById(Integer id) {
        return 0;
    }

    @Override
    public User updateUserById(Integer id) {
        return null;
    }

    @Override
    public User updateUserRoleById(Integer id) {
        return null;
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
    public User login(String phone, String password) {
        return null;
    }


}
