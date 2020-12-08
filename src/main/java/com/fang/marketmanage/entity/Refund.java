package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
public class Refund {
    private Integer id;
    private Integer goodId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Integer quantity;
    private Integer unitId;
    private Integer price;
    private  String reason;
}
