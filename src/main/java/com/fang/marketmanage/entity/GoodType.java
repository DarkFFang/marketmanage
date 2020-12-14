package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 类 {@code GoodType} 商品类型.
 *
 * @author fang
 * @since 2020/12/14
 */
@Getter
@Setter
@ToString
public class GoodType {
    /**
     * 类型编号
     */
    private Integer id;
    /**
     * 类型名称
     */
    private String name;
}
