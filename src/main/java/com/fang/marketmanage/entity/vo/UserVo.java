package com.fang.marketmanage.entity.vo;

import com.fang.marketmanage.entity.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class UserVo {
    private Integer id;
    private String username;
    private String phone;
    private String sex;
    private List<Role> roles;
}
