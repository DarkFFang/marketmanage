package com.fang.marketmanage.controller.admin;

import com.fang.marketmanage.entity.User;
import com.fang.marketmanage.service.UserService;
import com.fang.marketmanage.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/admin/user")
public class UserManageController {
    @Autowired
    UserService userService;

    @Autowired
    UserUtil userUtil=new UserUtil();

    @RequestMapping("/toadd")
    public String toadd(){
        return "admin/add";
    }

    @RequestMapping("/add")
    public String addNewUser(User user) {
        user.setPassword("111111");
        user.setId(userUtil.getId());
        System.out.println(user.toString());
        userService.addNewUser(user);
        return "redirect:list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<User> findUserList(Model model) {
        List<User> userlist=userService.findUserList();
        model.addAttribute("list",userlist);
        return userlist;
    }
}
