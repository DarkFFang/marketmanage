package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
public class InventoryRecord {
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
}