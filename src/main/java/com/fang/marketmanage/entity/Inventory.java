package com.fang.marketmanage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String other;
}
