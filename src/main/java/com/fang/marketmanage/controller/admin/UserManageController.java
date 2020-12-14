package com.fang.marketmanage.controller.admin;

import com.fang.marketmanage.annotation.CustomLog;
import com.fang.marketmanage.entity.Role;
import com.fang.marketmanage.entity.User;
import com.fang.marketmanage.entity.vo.UserVo;
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


/**
 * 用户管理控制器
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
@RequestMapping("/admin")
public class UserManageController {
    /**
     * 用户服务
     */
    @Autowired
    private UserService userService;

    /**
     * 用户列表
     *
     * @return {@link List<UserVo>}
     */
    @GetMapping("/user")
    @PreAuthorize("hasAuthority('/admin/user/**;GET')")
    public List<UserVo> findUserList() {
        List<UserVo> userlist = userService.findUserList();
        return userlist;
    }

    /**
     * 添加新用户
     *
     * @param user 用户
     * @return {@link RespUtil}
     */
    @PostMapping("/user")
    @PreAuthorize("hasAuthority('/admin/user/**;POST')")
    @CustomLog(operation = "添加新用户")
    public RespUtil addNewUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        if (userService.addNewUser(user) == 1) {
            return RespUtil.success("添加成功！");
        } else {
            return RespUtil.error("添加失败！");
        }
    }


    /**
     * 通过id更新用户
     *
     * @param user 用户
     * @return {@link RespUtil}
     */
    @PutMapping("/user")
    @PreAuthorize("hasAuthority('/admin/user/**;PUT')")
    @CustomLog(operation = "修改用户信息")
    public RespUtil updateUserById(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        if (userService.updateUserById(user) == 1) {
            return RespUtil.success("修改成功！");
        } else {
            return RespUtil.error("修改失败！");
        }
    }

    /**
     * 通过id删除用户
     *
     * @param id id
     * @return {@link RespUtil}
     */
    @DeleteMapping("/user/{id}")
    @PreAuthorize("hasAuthority('/admin/user/**;DELETE')")
    @CustomLog(operation = "删除用户")
    public RespUtil deleteUserById(@PathVariable Integer id) {
        if (userService.deleteUserById(id) == 1) {
            return RespUtil.success("删除成功！");
        } else {
            return RespUtil.error("删除失败");
        }
    }
}
