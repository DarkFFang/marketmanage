package com.fang.marketmanage.entity.vo;

import com.fang.marketmanage.entity.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
/**
 * 类 {@code UserVo} 用户显示信息表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Setter
@Getter
@ToString
public class UserVo {
    /**
     * 编号
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
     * 性别
     */
    private String sex;
    /**
     * 角色
     */
    private List<Role> roles;
}
