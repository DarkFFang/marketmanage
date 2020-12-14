package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 类 {@code Good} 商品.
 *
 * @author fang
 * @since 2020/12/14
 */
@Getter
@Setter
@ToString
public class Good {
    /**
     * 商品编号
     */
    private Integer id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 类型编号
     */
    private Integer typeId;
    /**
     * 生产日期
     */
    private Date sDate;
    /**
     * 变质日期
     */
    private Date eDate;
    /**
     * 商品单价
     */
    private Integer price;
    /**
     * 单位编号
     */
    private Integer unitId;
    /**
     * 备注
     */
    private String other;
}
