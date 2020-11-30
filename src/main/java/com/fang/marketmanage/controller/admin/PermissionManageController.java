package com.fang.marketmanage.controller.admin;

import com.fang.marketmanage.entity.Permission;
import com.fang.marketmanage.entity.PermissionVo;
import com.fang.marketmanage.service.RoleService;
import com.fang.marketmanage.util.Resp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Api
public class PermissionManageController {
    @Autowired
    RoleService roleService;

    @GetMapping("/permission")
    public List<PermissionVo> findAllPermissions() {
        return roleService.findAllPermissions();
    }

    @PostMapping("/rolepermission")
    public Resp addNewRolePermissions(Integer roleid,Integer[] permissionids) {
        if (roleService.addNewRolePermissions(roleid, permissionids) == permissionids.length) {
            return Resp.success("添加成功");
        }
        return Resp.error("添加失败");
    }

    @PutMapping("/rolepermission")
    public Resp updateRolePermissions(Integer roleid, Integer[] permissionids) {
        if (roleService.updateRolePermissions(roleid, permissionids) == permissionids.length) {
            return Resp.success("修改成功");
        }
        return Resp.error("修改失败");
    }

    @DeleteMapping("/rolepermission/{roleid}")
    public Resp deleteRolePermissionByRoleId(@PathVariable Integer roleid) {
        if (roleService.deleteRolePermissionByRoleId(roleid) > 0) {
            return Resp.success("删除成功");
        }
        return Resp.error("删除失败");
    }

    @GetMapping("/rolepermission/{roleid}")
    public List<PermissionVo> findPermissionsByRoleId(@PathVariable Integer roleid) {
        return roleService.findPermissionsByRoleId(roleid);
    }
}
