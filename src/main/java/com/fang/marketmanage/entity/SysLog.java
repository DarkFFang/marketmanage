package com.fang.marketmanage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@ToString
public class SysLog {
    private Integer id;
    private Integer userId;
    private String userPhone;
    private String username;
    private String operation;
    private String method;
    private String ip;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
}