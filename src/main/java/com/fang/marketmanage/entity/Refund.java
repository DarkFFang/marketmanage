package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/**
 * 类 {@code Refund} 退货表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Getter
@Setter
@ToString
public class Refund {
    /**
     * 退货表项编号
     */
    private Integer id;
    /**
     *商品编号
     */
    private Integer goodId;
    /**
     * 商品退货日期
     */
    private Date date;
    /**
     * 退货数量
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
    /**
     * 退货理由
     */
    private  String reason;
}
