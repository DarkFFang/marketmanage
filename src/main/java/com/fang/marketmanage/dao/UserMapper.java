package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.User;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //公共方法
    User login(String phone, String password);//登录

    User update(String name, String phone, String password, String sex);//修改个人信息

    //系统管理员
    int addNewUser(User user);//增加用户

    List<User> findUserList();//用户列表

    int deleteUserById(Integer id);//删除用户

    User updateUserById(Integer id);//修改用户

    List<User> findUserByUsername(String username);//通过用户名查询用户

    List<User> findClerkList();//搜索营业员列表

    List<User> findKeeperList();//搜索库管员列表


}
