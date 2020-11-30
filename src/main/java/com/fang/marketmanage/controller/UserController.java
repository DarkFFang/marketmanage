package com.fang.marketmanage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/currentUserName")
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
}
