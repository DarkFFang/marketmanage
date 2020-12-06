package com.fang.marketmanage.controller.admin;

import com.fang.marketmanage.entity.Role;
import com.fang.marketmanage.entity.User;
import com.fang.marketmanage.service.RoleService;
import com.fang.marketmanage.service.UserService;
import com.fang.marketmanage.util.RespUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
@Api
public class UserManageController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('/admin/user/**;GET')")
    public List<User> findUserList() {
        List<User> userlist = userService.findUserList();
        return userlist;
    }

    @PostMapping("/user")
    @PreAuthorize("hasAuthority('/admin/user/**;POST')")
    public RespUtil addNewUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        if (userService.addNewUser(user) == 1) {
            return RespUtil.success("添加成功！");
        } else {
            return RespUtil.error("添加失败！");
        }
    }


    @PutMapping("/user")
    @PreAuthorize("hasAuthority('/admin/user/**;PUT')")
    public RespUtil updateUserById(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        if (userService.updateUserById(user) == 1) {
            return RespUtil.success("修改成功！");
        } else {
            return RespUtil.error("修改失败！");
        }
    }

    @DeleteMapping("/user/{id}")
    @PreAuthorize("hasAuthority('/admin/user/**;DELETE')")
    public RespUtil deleteUserById(@PathVariable Integer id) {
        if (userService.deleteUserById(id) == 1) {
            userService.alterUserAutoIncrement();
            return RespUtil.success("删除成功！");
        } else {
            return RespUtil.error("删除失败");
        }
    }
}
