/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.entity.building;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Digits;

/**
 * Created by cspark on 2017. 1. 17..
 */
@Embeddable
@Data
public class Parking {
    /**
     * 옥내_기계식_대수(대)
     * cf. indrMechUtcnt
     */
    @Digits(integer = 6, fraction = 0)
    @Column(precision = 6)
    private Integer inMechCnt;

    /**
     * 옥내_기계식_면적(㎡)
     * cf. indrMechArea
     */
    @Digits(integer=10, fraction=2)
    @Column(precision=12, scale=2, columnDefinition = "DECIMAL(12,2)")
    private Double inMechArea;

    /**
     * 옥내_자주식_대수(대)
     * cf. indrAutoUtcnt
     */
    @Digits(integer = 6, fraction = 0)
    @Column(precision = 6)
    private Integer inAutoCnt;

    /**
     * 옥내_자주식_면적(㎡) indrAutoArea
     */
    @Digits(integer=10, fraction=2)
    @Column(precision=12, scale=2, columnDefinition = "DECIMAL(12,2)")
    private Double inAutoArea;

    /**
     * 옥외_기계식_대수(대)
     * cf. oudrMechUtcnt
     */
    @Digits(integer = 6, fraction = 0)
    @Column(precision = 6)
    private Integer outMechCnt;

    /**
     * 옥외_기계식_면적(㎡)
     * cf. oudrMechArea
     */
    @Digits(integer=10, fraction=2)
    @Column(precision=12, scale=2, columnDefinition = "DECIMAL(12,2)")
    private Double outMechArea;

    /**
     * 옥외_자주식_대수(대)
     * cf. oudrAutoUtcnt
     */
    @Digits(integer = 6, fraction = 0)
    @Column(precision = 6)
    private Integer outAutoCnt;

    /**
     * 옥외_자주식_면적(㎡)
     * cf. oudrAutoArea
     */
    @Digits(integer=10, fraction=2)
    @Column(precision=12, scale=2, columnDefinition = "DECIMAL(12,2)")
    private Double outAutoArea;

}
