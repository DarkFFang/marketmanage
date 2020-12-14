package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 类 {@code RolePermission} 角色权限表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Getter
@Setter
@ToString
public class RolePermission {
    /**
     * 角色权限编号
     */
    private Integer id;
    /**
     * 角色编号
     */
    private Integer roleId;
    /**
     * 权限编号
     */
    private Integer permissionId;
}
