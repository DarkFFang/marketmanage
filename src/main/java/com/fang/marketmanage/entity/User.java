package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 类 {@code User} 用户表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Getter
@Setter
@ToString
public class User {
    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private String sex;
}
