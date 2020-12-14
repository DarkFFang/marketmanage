package com.fang.marketmanage.controller.admin;

import com.fang.marketmanage.annotation.CustomLog;
import com.fang.marketmanage.entity.Role;
import com.fang.marketmanage.service.RoleService;
import com.fang.marketmanage.util.RespUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色管理控制器
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
@RequestMapping("/admin")
public class RoleManageController {
    /**
     * 角色服务
     */
    @Autowired
    private RoleService roleService;

    /**
     * 所有的角色列表
     *
     * @return {@link List<Role>}
     */
    @GetMapping("/role")
    @PreAuthorize("hasAuthority('/admin/role/**;GET')")
    public List<Role> findAllRole() {
        return roleService.findAllRole();
    }

    /**
     * 添加新角色
     *
     * @param role 角色
     * @return {@link RespUtil}
     */
    @PostMapping("/role")
    @PreAuthorize("hasAuthority('/admin/role/**;POST')")
    @CustomLog(operation = "添加角色")
    public RespUtil addNewRole(Role role) {
        if (roleService.addNewRole(role) == 1) {
            return RespUtil.success("添加成功");
        }
        return RespUtil.error("添加失败");
    }

    /**
     * 通过id更新角色
     *
     * @param role 角色
     * @return {@link RespUtil}
     */
    @PutMapping("/role")
    @PreAuthorize("hasAuthority('/admin/role/**;PUT')")
    @CustomLog(operation = "修改角色")
    public RespUtil updateRoleById(Role role) {
        if (roleService.updateRoleById(role) == 1) {
            return RespUtil.success("修改成功");
        }
        return RespUtil.error("修改失败");
    }

    /**
     * 通过id删除角色
     *
     * @param id id
     * @return {@link RespUtil}
     */
    @DeleteMapping("/role/{id}")
    @PreAuthorize("hasAuthority('/admin/role/**;DELETE')")
    @CustomLog(operation = "删除角色")
    public RespUtil deleteRoleById(@PathVariable Integer id) {
        if (roleService.deleteRoleById(id) == 1) {
            return RespUtil.success("删除成功");
        }
        return RespUtil.error("删除失败");
    }

    /**
     * 添加新用户角色
     *
     * @param userid 用户标识
     * @param roleid roleid
     * @return {@link RespUtil}
     */
    @PostMapping("/user_role")
    @PreAuthorize("hasAuthority('/admin/userrole/**;POST')")
    @CustomLog(operation = "为用户添加角色")
    public RespUtil addNewUserRole(Integer userid, Integer roleid) {
        if (roleService.addNewUserRole(userid, roleid) == 1) {
            return RespUtil.success("添加成功");
        }
        return RespUtil.error("添加失败");
    }

    /**
     * 更新用户角色
     *
     * @param userid 用户标识
     * @param roleid roleid
     * @return {@link RespUtil}
     */
    @PutMapping("/user_role")
    @PreAuthorize("hasAuthority('/admin/userrole/**;PUT')")
    @CustomLog(operation = "修改用户角色")
    public RespUtil updateUserRole(Integer userid, Integer roleid) {
        if (roleService.updateUserRole(userid, roleid) == 1) {
            return RespUtil.success("修改成功");
        }
        return RespUtil.error("修改失败");
    }

    /**
     * 通过id删除用户角色
     *
     * @param userid 用户编号
     * @return {@link RespUtil}
     */
    @DeleteMapping("/user_role/{userid}")
    @PreAuthorize("hasAuthority('/admin/userrole/**;DELETE')")
    @CustomLog(operation = "删除用户角色")
    public RespUtil deleteUserRoleByUserId(@PathVariable Integer userid) {
        if (roleService.deleteUserRoleByUserId(userid) == 1) {
            return RespUtil.success("删除成功");
        }
        return RespUtil.error("删除失败");
    }
}
