package com.fang.marketmanage.util;

import com.fang.marketmanage.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtil {
    public static User getCurrentUser(){
        User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
}
