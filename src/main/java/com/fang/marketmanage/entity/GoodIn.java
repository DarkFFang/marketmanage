package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 类 {@code GoodIn} 商品入库表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Getter
@Setter
@ToString
public class GoodIn {
    /**
     * 入库编号
     */

    private Integer id;
    /**
     * 入库时间
     */
    private Date date;
    /**
     * 供应商编号
     */
    private Integer supplierId;
    /**
     * 商品编号
     */
    private Integer goodId;
    /**
     * 数量
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
     * 支付款项
     */
    private Integer paid;
    /**
     * 用户编号
     */
    private Integer userId;

}
