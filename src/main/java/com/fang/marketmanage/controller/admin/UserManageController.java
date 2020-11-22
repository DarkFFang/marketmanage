package com.fang.marketmanage.controller.admin;

import com.fang.marketmanage.entity.User;
import com.fang.marketmanage.service.UserService;
import com.fang.marketmanage.util.Resp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin/user")
@Api(value = "用户管理接口")
public class UserManageController {
    @Autowired
    UserService userService;


    @PostMapping("/add")
    public Resp addNewUser(User user) {
        if (userService.addNewUser(user)==1){
            return Resp.success("添加成功！");
        } else {
            return Resp.error("添加失败！");
        }
    }

    @GetMapping("/list")
    public List<User> findUserList() {
        List<User> userlist=userService.findUserList();
        System.out.println(userlist);
        return userlist;
    }

    @PutMapping("/update")
    public Resp updateUserById(User user){
        if (userService.updateUserById(user)==1){
            return Resp.success("修改成功！");
        } else {
            return Resp.error("修改失败！");
        }
    }

    @DeleteMapping("/delete/{id}")
    public Resp deleteUserById(@PathVariable Integer id){
        if (userService.deleteUserById(id)==1){
            return Resp.success("删除成功！");
        } else {
            return Resp.error("删除失败");
        }
    }
}
