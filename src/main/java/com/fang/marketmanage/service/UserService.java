package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.User;

import java.util.List;

public interface UserService {
    public User login(String phone,String password);

    public int addNewUser(User user);

    public List<User> findUserList();
}
