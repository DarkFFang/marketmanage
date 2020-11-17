package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class WorkTime {
    private Integer userId;
    private Integer roleId;
    private Date sDate;
    private Date eDate;
    private String workDay;
}
