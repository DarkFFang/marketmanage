package com.fang.marketmanage.controller.admin;

import com.fang.marketmanage.entity.vo.PermissionVo;
import com.fang.marketmanage.service.RoleService;
import com.fang.marketmanage.util.RespUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class PermissionManageController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/permission")
    @PreAuthorize("hasAuthority('/admin/permission/**;GET')")
    public List<PermissionVo> findAllPermissions() {
        return roleService.findAllPermissions();
    }

    @PostMapping("/role_permission")
    @PreAuthorize("hasAuthority('/admin/rolepermission/**;POST')")
    public RespUtil addNewRolePermissions(Integer roleid, Integer[] permissionids) {
        if (roleService.addNewRolePermissions(roleid, permissionids) == permissionids.length) {
            return RespUtil.success("添加成功");
        }
        return RespUtil.error("添加失败");
    }

    @PutMapping("/role_permission")
    @PreAuthorize("hasAuthority('/admin/rolepermission/**;PUT')")
    public RespUtil updateRolePermissions(Integer roleid, Integer[] permissionids) {
        if (roleService.updateRolePermissions(roleid, permissionids) == permissionids.length) {
            return RespUtil.success("修改成功");
        }
        return RespUtil.error("修改失败");
    }

    @DeleteMapping("/role_permission/{roleid}")
    @PreAuthorize("hasAuthority('/admin/rolepermission/**;DELETE')")
    public RespUtil deleteRolePermissionByRoleId(@PathVariable Integer roleid) {
        if (roleService.deleteRolePermissionByRoleId(roleid) > 0) {
            return RespUtil.success("删除成功");
        }
        return RespUtil.error("删除失败");
    }

    @GetMapping("/role_permission/{roleid}")
    @PreAuthorize("hasAuthority('/admin/rolepermission/**;GET')")
    public List<PermissionVo> findPermissionsByRoleId(@PathVariable Integer roleid) {
        return roleService.findPermissionsByRoleId(roleid);
    }
}
