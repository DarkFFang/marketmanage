package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 类 {@code Permission} 用户权限表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Getter
@Setter
@ToString
public class Permission {
    /**
     * 权限编号
     */
    private Integer id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限URL
     */
    private String url;
    /**
     * 父权限编号
     */
    private Integer pId;
    /**
     * 方法
     */
    private String method;
}
