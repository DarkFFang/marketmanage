package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 类 {@code Role} 用户角色表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Getter
@Setter
@ToString
public class Role {
    /**
     * 角色编号
     */
    private Integer id;
    /**
     * 角色名称
     */
    private String name;
}
