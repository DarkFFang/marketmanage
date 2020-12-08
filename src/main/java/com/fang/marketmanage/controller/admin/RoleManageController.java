package com.fang.marketmanage.controller.admin;

import com.fang.marketmanage.entity.Role;
import com.fang.marketmanage.service.RoleService;
import com.fang.marketmanage.util.RespUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Api
public class RoleManageController {
    @Autowired
    RoleService roleService;

    @GetMapping("/role")
    @PreAuthorize("hasAuthority('/admin/role/**;GET')")
    public List<Role> findAllRole() {
        return roleService.findAllRole();
    }

    @PostMapping("/role")
    @PreAuthorize("hasAuthority('/admin/role/**;POST')")
    public RespUtil addNewRole(Role role) {
        if (roleService.addNewRole(role) == 1) {
            return RespUtil.success("添加成功");
        }
        return RespUtil.error("添加失败");
    }

    @PutMapping("/role")
    @PreAuthorize("hasAuthority('/admin/role/**;PUT')")
    public RespUtil updateRoleById(Role role) {
        if (roleService.updateRoleById(role) == 1) {
            return RespUtil.success("修改成功");
        }
        return RespUtil.error("修改失败");
    }

    @DeleteMapping("/role/{id}")
    @PreAuthorize("hasAuthority('/admin/role/**;DELETE')")
    public RespUtil deleteRoleById(@PathVariable Integer id) {
        if (roleService.deleteRoleById(id) == 1) {
            return RespUtil.success("删除成功");
        }
        return RespUtil.error("删除失败");
    }

    @PostMapping("/userrole")
    @PreAuthorize("hasAuthority('/admin/userrole/**;POST')")
    public RespUtil addNewUserRole(Integer userid, Integer roleid) {
        if (roleService.addNewUserRole(userid, roleid) == 1) {
            return RespUtil.success("添加成功");
        }
        return RespUtil.error("添加失败");
    }

    @PutMapping("/userrole")
    @PreAuthorize("hasAuthority('/admin/userrole/**;PUT')")
    public RespUtil updateUserRole(Integer userid, Integer roleid) {
        if (roleService.updateUserRole(userid, roleid) == 1) {
            return RespUtil.success("修改成功");
        }
        return RespUtil.error("修改失败");
    }

    @DeleteMapping("/userrole/{userid}")
    @PreAuthorize("hasAuthority('/admin/userrole/**;DELETE')")
    public RespUtil deleteUserRoleByUserId(@PathVariable Integer userid) {
        if (roleService.deleteUserRoleByUserId(userid) == 1) {
            return RespUtil.success("删除成功");
        }
        return RespUtil.error("删除失败");
    }
}
