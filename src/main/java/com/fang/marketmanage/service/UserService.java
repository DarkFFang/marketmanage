package com.fang.marketmanage.service;

import com.fang.marketmanage.entity.User;

import java.util.List;

public interface UserService {
    //公共方法
    User login(String phone, String password);//登录

    User update(Integer id);//修改个人信息

    User exit();//退出登录

    //系统管理员
    User register(User user);//注册用户（仅对管理员）

    int addNewUser(User user);//增加用户（营业员或库管员）

    List<User> findUserList();//用户列表（营业员和库管员）

    int deleteUserById(Integer id);//删除用户（营业员或库管员）

    User updateUserById(Integer id);//修改用户（营业员或库管员）

    User updateUserRoleById(Integer id);//修改用户（营业员或库管员）

    List<User> findUserByUsername(String username);//通过用户名（营业员或库管员）查询用户

    List<User> findClerkList();//搜索营业员列表

    List<User> findKeeperList();//搜索库管员列表
}
