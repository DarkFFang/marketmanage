package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 类 {@code Unit} 商品单位表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Getter
@Setter
@ToString
public class Unit {
    /**
     * 单位编号
     */
    private Integer id;
    /**
     * 单位名称
     */
    private String name;
}
