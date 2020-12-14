package com.fang.marketmanage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 类 {@code Inventory} 商品盘存表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Getter
@Setter
@ToString
public class Inventory {
    /**
     * 商品编号
     */
    private Integer goodId;
    /**
     * 盘存日期
     */
    private Date date;
    /**
     * 商品名称
     */
    private String goodName;
    /**
     * 商品库存数量
     */
    private Integer quantity;
    /**
     * 商品实际数量
     */
    private Integer newQuantity;
    /**
     * 单位编号
     */
    private Integer unitId;
    /***/
    private Integer yk;
    private String other;
}
