package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Inventory {
    private Integer goodId;
    private Date date;
    private String goodName;
    private Integer quantity;
    private Integer newQuantity;
    private Integer unitId;
    private Integer yk;
}
