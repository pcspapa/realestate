/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.entity.building;

import lombok.Data;

import javax.persistence.Embeddable;

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
    private String inMechCnt;

    /**
     * 옥내_기계식_면적(㎡)
     * cf. indrMechArea
     */
    private String inMechArea;

    /**
     * 옥내_자주식_대수(대)
     * cf. indrAutoUtcnt
     */
    private String inAutoCnt;

    /**
     * 옥내_자주식_면적(㎡) indrAutoArea
     */
    private String inAutoArea;

    /**
     * 옥외_기계식_대수(대)
     * cf. oudrMechUtcnt
     */
    private String outMechCnt;

    /**
     * 옥외_기계식_면적(㎡)
     * cf. oudrMechArea
     */
    private String outMechArea;

    /**
     * 옥외_자주식_대수(대)
     * cf. oudrAutoUtcnt
     */
    private String outAutoCnt;

    /**
     * 옥외_자주식_면적(㎡)
     * cf. oudrAutoArea
     */
    private String outAutoArea;

}
