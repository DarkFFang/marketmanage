package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
public class WorkTime {
    private Integer userId;
    private Integer roleId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eDate;
    private String workDay;
}
