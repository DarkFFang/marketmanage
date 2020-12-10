package com.fang.marketmanage.controller;

import com.fang.marketmanage.annotation.CustomLog;
import com.fang.marketmanage.entity.JwtUser;
import com.fang.marketmanage.entity.Role;
import com.fang.marketmanage.entity.User;
import com.fang.marketmanage.entity.vo.UserVo;
import com.fang.marketmanage.service.RoleService;
import com.fang.marketmanage.service.UserService;
import com.fang.marketmanage.util.RespUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/user")
    public UserVo findCurrentUser() {
        JwtUser jwtUser = (JwtUser) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        User user = userService.findUserById(jwtUser.getId());
        List<Role> roles = roleService.findRolesByUserId(jwtUser.getId());
        UserVo userVo = new UserVo();
        userVo.setId(user.getId());
        userVo.setUsername(user.getUsername());
        userVo.setPhone(user.getPhone());
        userVo.setSex(user.getSex());
        userVo.setRoles(roles);
        return userVo;
    }

    @PutMapping("/user/password")
    @CustomLog(operation = "修改用户密码")
    public RespUtil updateCurrentUserPassword(Integer id, String oldPassword, String newPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = userService.findUserById(id);
        log.debug(user.toString());
        if (encoder.matches(oldPassword, user.getPassword())) {
            log.debug(oldPassword);
            user.setPassword(encoder.encode(newPassword));
            userService.updateUserById(user);
            return RespUtil.success("密码修改成功！");
        }
        return RespUtil.error("旧密码错误，修改失败！");
    }
}
