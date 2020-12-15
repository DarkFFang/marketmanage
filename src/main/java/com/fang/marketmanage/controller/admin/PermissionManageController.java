package com.fang.marketmanage.controller.admin;

import com.fang.marketmanage.entity.vo.PermissionVo;
import com.fang.marketmanage.service.RoleService;
import com.fang.marketmanage.util.RedisUtil;
import com.fang.marketmanage.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * 权限管理控制器
 *
 * @author fang
 * @date 2020/12/14
 */
@RestController
@RequestMapping("/admin")
public class PermissionManageController {
    /**
     * 角色服务
     */
    @Autowired
    private RoleService roleService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 所有的权限列表
     *
     * @return {@link List<PermissionVo>}
     */
    @GetMapping("/permission")
    @PreAuthorize("hasAuthority('/admin/permission/**;GET')")
    public List<PermissionVo> findAllPermissions() {
        return roleService.findAllPermissions();
    }


    /**
     * 添加新角色权限
     *
     * @param roleid        roleid
     * @param permissionids permissionids
     * @return {@link RespUtil}
     */
    /*
    @PostMapping("/role_permission")
    @PreAuthorize("hasAuthority('/admin/rolepermission/**;POST')")
    public RespUtil addNewRolePermissions(Integer roleid, Integer[] permissionids) {
        if (roleService.addNewRolePermissions(roleid, permissionids) == permissionids.length) {
            return RespUtil.success("添加成功");
        }
        return RespUtil.error("添加失败");
    }

     */

    /**
     * 更新角色权限
     *
     * @param roleid        roleid
     * @param permissionids permissionids
     * @return {@link RespUtil}
     */
    @PutMapping("/role_permission")
    @PreAuthorize("hasAuthority('/admin/rolepermission/**;PUT')")
    public RespUtil updateRolePermissions(Integer roleid, Integer[] permissionids) {
        if (roleService.updateRolePermissions(roleid, permissionids) == permissionids.length) {
            Set keySet = redisUtil.keys("user:*");
            String[] keys = (String[]) keySet.toArray(new String[keySet.size()]);
            redisUtil.del(keys);

            return RespUtil.success("修改成功");
        }
        return RespUtil.error("修改失败");
    }

    /**
     * 通过id删除角色权限
     *
     * @param roleid roleid
     * @return {@link RespUtil}
     */
    /*
    @DeleteMapping("/role_permission/{roleid}")
    @PreAuthorize("hasAuthority('/admin/rolepermission/**;DELETE')")
    public RespUtil deleteRolePermissionByRoleId(@PathVariable Integer roleid) {
        if (roleService.deleteRolePermissionByRoleId(roleid) > 0) {
            return RespUtil.success("删除成功");
        }
        return RespUtil.error("删除失败");
    }

     */

    /**
     * 通过角色查询权限
     *
     * @param roleid roleid
     * @return {@link List<PermissionVo>}
     */
    @GetMapping("/role_permission/{roleid}")
    @PreAuthorize("hasAuthority('/admin/rolepermission/**;GET')")
    public List<PermissionVo> findPermissionsByRoleId(@PathVariable Integer roleid) {
        return roleService.findPermissionsByRoleId(roleid);
    }
}
