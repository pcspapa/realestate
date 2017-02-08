/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.entity.address;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Digits;
import java.io.Serializable;

/**
 * Created by cspark on 2017. 2. 1..
 */
@Data
@IdClass(AddressJibunPool.AddressJibunPoolId.class)
public class AddressJibunPool {

    /** 관리번호 */
    @Id
    @Column(name = "mgt_no")
    @JoinColumn(name = "mgt_no", insertable = false, updatable = false)
    private String mgtNo;

    /** 일련번호 */
    @Id
    @Digits(integer = 3, fraction = 0)
    @Column(precision = 3)
    private Integer sno;

    /** 법정동코드 */
    private String legalDongCode;

    /** 시도명칭 */
    private String sdName;

    /** 시군구명칭 */
    private String sggName;

    /** 법정읍면동명칭 */
    private String legalEmdName;

    /** 법정리명 */
    private String legalLiName;

    /** 산여부 */
    private boolean mountain;

    /** 지번본번(번지) */
    @Digits(integer = 4, fraction = 0)
    @Column(precision = 4)
    private Integer landMainNo;

    /** 지번부번(호) */
    @Digits(integer = 4, fraction = 0)
    @Column(precision = 4)
    private Integer landSubNo;

    /** 대표여부 */
    private String representable;


    @Data
    public static class AddressJibunPoolId implements Serializable {

        /** 관리번호 */
        private String mgtNo;

        /** 일련번호 */
        private Integer sno;

    }
}

