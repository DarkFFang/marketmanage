package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/**
 * 类 {@code Stock} 库存表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Getter
@Setter
@ToString
public class Stock {
    /**
     * 商品编号
     */
    private Integer goodId;
    /**
     * 更新时间
     */
    private Date date;
    /**
     * 商品数量
     */
    private Integer quantity;
    /**
     * 单位编号
     */
    private Integer unitId;
    /**
     * 总金额
     */
    private Integer price;
}
