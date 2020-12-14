package com.fang.marketmanage.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 类 {@code Supplier} 供应商表.
 *
 * @author fang
 * @since 2020/12/14
 */
@Getter
@Setter
@ToString
public class Supplier {
    /**
     * 供应商编号
     */
    private Integer id;
    /**
     * 供应商名称
     */
    private String name;
    /**
     * 地址
     */
    private String address;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 传真
     */
    private String fax;
    /**
     * 信誉
     */
    private String reputation;
    /**
     * 欠款
     */
    private Integer loan;
}
