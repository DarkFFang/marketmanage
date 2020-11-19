package com.fang.marketmanage.controller.admin;

import com.fang.marketmanage.entity.User;
import com.fang.marketmanage.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("管理用户API接口")
@RestController
@RequestMapping("/admin/user")
public class UserManageController {
    @Autowired
    UserService userService;


    @PostMapping("/add")
    public String addNewUser(User user) {
        user.setPassword("111111");
        System.out.println(user.toString());
        userService.addNewUser(user);
        return "redirect:list";
    }

    @GetMapping("/list")
    public List<User> findUserList(Model model) {
        List<User> userlist=userService.findUserList();
        model.addAttribute("list",userlist);
        return userlist;
    }
}
