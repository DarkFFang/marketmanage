package com.fang.marketmanage.controller.admin;

import com.fang.marketmanage.entity.Role;
import com.fang.marketmanage.service.RoleService;
import com.fang.marketmanage.util.Resp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Api
public class RoleManageController {
    @Autowired
    RoleService roleService;

    @GetMapping("/role")
    public List<Role> findAllRole() {
        return roleService.findAllRole();
    }

    @PostMapping("/role")
    public Resp addNewRole(Role role) {
        if (roleService.addNewRole(role) == 1) {
            return Resp.success("添加成功");
        }
        return Resp.error("添加失败");
    }
    @PutMapping("/role")
    public Resp updateRoleById(Role role) {
        if (roleService.updateRoleById(role) == 1) {
            return Resp.success("修改成功");
        }
        return Resp.error("修改失败");
    }
    @DeleteMapping("/role/{id}")
    public Resp deleteRoleById(@PathVariable Integer id) {
        if (roleService.deleteRoleById(id) == 1) {
            return Resp.success("删除成功");
        }
        return Resp.error("删除失败");
    }

    @PostMapping("/userrole")
    public Resp addNewUserRole(Integer userid, Integer roleid) {
        if (roleService.addNewUserRole(userid, roleid) == 1) {
            return Resp.success("添加成功");
        }
        return Resp.error("添加失败");
    }

    @PutMapping("/userrole")
    public Resp updateUserRole(Integer userid, Integer roleid) {
        if (roleService.updateUserRole(userid,roleid) == 1) {
            return Resp.success("修改成功");
        }
        return Resp.error("修改失败");
    }
    @DeleteMapping("/userrole/{userid}")
    public Resp deleteUserRoleByUserId(@PathVariable Integer userid) {
        if (roleService.deleteUserRoleByUserId(userid) == 1) {
            return Resp.success("删除成功");
        }
        return Resp.error("删除失败");
    }
}
