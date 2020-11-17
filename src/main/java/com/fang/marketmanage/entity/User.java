package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String id;
    private String username;
    private String phone;
    private String password;
    private String sex;
    private Integer roleId;
}
