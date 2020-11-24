package com.fang.marketmanage.controller;

import com.fang.marketmanage.util.UserUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/currentUserName")
    public String currentUserName() {
        return UserUtil.getCurrentUser().getUsername();
    }
}
