package com.fang.marketmanage.dao;

import com.fang.marketmanage.entity.Role;
import com.fang.marketmanage.entity.User;
import com.fang.marketmanage.entity.vo.UserVo;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //系统管理员
    int addNewUser(User user);//增加用户（营业员或库管员）

    List<UserVo> findUserList();//用户列表（营业员和库管员）

    User findUserById(Integer id);

    int deleteUserById(Integer id);//删除用户（营业员或库管员）

    int updateUserById(User user);//修改用户（营业员或库管员）

    int updateUserRoleById(Integer id);//修改用户（营业员或库管员）

    List<User> findUserByUsername(String username);//通过用户名（营业员或库管员）查询用户

    User findUserByPhone(String phone);

    List<User> findClerkList();//搜索营业员列表

    List<User> findKeeperList();//搜索库管员列表

    int addPermissionById();//增加用户权限

    int deletePermissionById();//删除用户权限

    int findPermissionById();//查询用户权限

    void alterUserAutoIncrement();

}
