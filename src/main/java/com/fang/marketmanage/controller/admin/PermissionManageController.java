package com.fang.marketmanage.controller.admin;

import com.fang.marketmanage.entity.Permission;
import com.fang.marketmanage.entity.PermissionVo;
import com.fang.marketmanage.service.RoleService;
import com.fang.marketmanage.util.Resp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Api
public class PermissionManageController {
    @Autowired
    RoleService roleService;

    @GetMapping("/permission")
    @PreAuthorize("hasAuthority('/admin/permission/**;GET')")
    public List<PermissionVo> findAllPermissions() {
        return roleService.findAllPermissions();
    }

    @PostMapping("/rolepermission")
    @PreAuthorize("hasAuthority('/admin/rolepermission/**;POST')")
    public Resp addNewRolePermissions(Integer roleid,Integer[] permissionids) {
        if (roleService.addNewRolePermissions(roleid, permissionids) == permissionids.length) {
            return Resp.success("添加成功");
        }
        return Resp.error("添加失败");
    }

    @PutMapping("/rolepermission")
    @PreAuthorize("hasAuthority('/admin/rolepermission/**;PUT')")
    public Resp updateRolePermissions(Integer roleid, Integer[] permissionids) {
        if (roleService.updateRolePermissions(roleid, permissionids) == permissionids.length) {
            return Resp.success("修改成功");
        }
        return Resp.error("修改失败");
    }

    @DeleteMapping("/rolepermission/{roleid}")
    @PreAuthorize("hasAuthority('/admin/rolepermission/**;DELETE')")
    public Resp deleteRolePermissionByRoleId(@PathVariable Integer roleid) {
        if (roleService.deleteRolePermissionByRoleId(roleid) > 0) {
            return Resp.success("删除成功");
        }
        return Resp.error("删除失败");
    }

    @GetMapping("/rolepermission/{roleid}")
    @PreAuthorize("hasAuthority('/admin/rolepermission/**;GET')")
    public List<PermissionVo> findPermissionsByRoleId(@PathVariable Integer roleid) {
        return roleService.findPermissionsByRoleId(roleid);
    }
}
