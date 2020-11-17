package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Stock {
    private Integer goodId;
    private Date date;
    private Integer quantity;
    private Integer unitId;
    private Integer price;
}
