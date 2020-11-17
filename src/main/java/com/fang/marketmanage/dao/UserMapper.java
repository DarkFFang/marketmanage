package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {


    User login(String phone,String password);

    int addNewUser(User user);

    List<User> findUserList();
}
