package com.fang.marketmanage.controller;

import com.fang.marketmanage.annotation.CustomLog;
import com.fang.marketmanage.entity.JwtUser;
import com.fang.marketmanage.entity.Role;
import com.fang.marketmanage.entity.User;
import com.fang.marketmanage.entity.vo.PermissionVo;
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

/**
 * 用户控制器
 *
 * @author fang
 * @date 2020/12/14
 */
@Slf4j
@RestController
public class UserController {
    /**
     * 用户服务
     */
    @Autowired
    private UserService userService;
    /**
     * 角色服务
     */
    @Autowired
    private RoleService roleService;

    /**
     * 查找当前用户
     *
     * @return {@link UserVo}
     */
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

    /**
     * 更新当前用户密码
     *
     * @param id          id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return {@link RespUtil}
     */
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

    /**
     * 通过用户id找到菜单
     *
     * @return {@link List<PermissionVo>}
     */
    @GetMapping("/user/menu")
    public List<PermissionVo> findMenuByUserId() {
        UserVo currentUser = findCurrentUser();
        return roleService.findMenuByUserId(currentUser.getId());
    }
}
