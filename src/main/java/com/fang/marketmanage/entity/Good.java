package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
public class Good {
    private Integer id;
    private String name;
    private Integer typeId;
    private Date sDate;
    private Date eDate;
    private Integer price;
    private Integer unitId;
    private String other;
}
