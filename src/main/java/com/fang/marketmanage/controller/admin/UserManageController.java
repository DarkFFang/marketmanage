package com.fang.marketmanage.controller.admin;

import com.fang.marketmanage.entity.Role;
import com.fang.marketmanage.entity.User;
import com.fang.marketmanage.service.RoleService;
import com.fang.marketmanage.service.UserService;
import com.fang.marketmanage.util.Resp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
@Api
public class UserManageController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;


    @PostMapping("/user")
    public Resp addNewUser(User user) {
        if (userService.addNewUser(user)==1){
            return Resp.success("添加成功！");
        } else {
            return Resp.error("添加失败！");
        }
    }

    @GetMapping("/user/list")
    public List<User> findUserList() {
        List<User> userlist=userService.findUserList();
        System.out.println(userlist);
        return userlist;
    }

    @PutMapping("/user")
    public Resp updateUserById(User user){
        if (userService.updateUserById(user)==1){
            return Resp.success("修改成功！");
        } else {
            return Resp.error("修改失败！");
        }
    }

    @DeleteMapping("/user/{id}")
    public Resp deleteUserById(@PathVariable Integer id){
        if (userService.deleteUserById(id)==1){
            return Resp.success("删除成功！");
        } else {
            return Resp.error("删除失败");
        }
    }

    @GetMapping("/roles")
    public List<Role> getRolesList() {
        return roleService.getRolesList();
    }
}
