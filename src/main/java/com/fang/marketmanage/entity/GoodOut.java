package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class GoodOut {
    private Integer id;
    private Date date;
    private Integer supplierId;
    private Integer goodId;
    private Integer quantity;
    private Integer unitId;
    private Integer price;
    private Integer paid;
    private Integer userId;
}
