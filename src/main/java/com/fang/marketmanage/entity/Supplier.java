package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Supplier {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String fax;
    private String reputation;
    private Integer loan;
}
