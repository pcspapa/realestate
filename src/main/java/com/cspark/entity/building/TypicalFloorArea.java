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
import javax.persistence.Embedded;
import javax.validation.constraints.Digits;

/**
 * Created by cspark on 2017. 1. 12..
 */
@Embeddable
@Data
public class TypicalFloorArea {

    @Embedded
    private Area rental;

    @Embedded
    private Area exclusive;

    /**
     * 전용율 (Exclusive Ratio)
     */
    @Digits(integer = 2, fraction = 0)
    @Column(precision = 2)
    private Integer exclusiveRatio;

    /**
     * 층고 (Floor Height)
     */
    @Digits(integer = 2, fraction = 0)
    @Column(precision = 2)
    private Integer floorHeight;
}
