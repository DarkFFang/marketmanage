package com.fang.marketmanage.entity.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 类 {@code PermissionVo} 权限显示表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Getter
@Setter
@ToString
public class PermissionVo {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 地址
     */
    private String url;
    /**
     * 权限名称
     */
    private String name;
}
