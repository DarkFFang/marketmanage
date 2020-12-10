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
public class WorkTime {
    private Integer id;
    private Integer userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date eDate;
    private String workDay;
}
