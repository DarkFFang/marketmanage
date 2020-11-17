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

    @Override
    public int addNewUser(User user) {
        return userMapper.addNewUser(user);
    }

    @Override
    public List<User> findUserList() {
        return userMapper.findUserList();
    }

    @Override
    public User login(String phone, String password) {
        return null;
    }
}
