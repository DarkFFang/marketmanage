package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Permission {
    private Integer id;
    private String name;
    private String url;
    private Integer pId;
    private String method;
}
