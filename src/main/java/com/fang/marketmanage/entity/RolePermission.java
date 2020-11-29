package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RolePermission {
    private Integer id;
    private Integer roleId;
    private Integer permissionId;
}
