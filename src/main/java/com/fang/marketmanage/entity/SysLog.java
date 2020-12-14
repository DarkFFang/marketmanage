package com.fang.marketmanage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/**
 * 类 {@code SysLog} 日志表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Setter
@Getter
@ToString
public class SysLog {
    /**
     * 日志编号
     */
    private Integer id;
    /**
     * 用户编号
     */
    private Integer userId;
    /**
     * 电话号码
     */
    private String userPhone;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 操作
     */
    private String operation;
    /**
     * 方法
     */
    private String method;
    /**
     * 位置
     */
    private String ip;
    /**
     * 操作时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
}
