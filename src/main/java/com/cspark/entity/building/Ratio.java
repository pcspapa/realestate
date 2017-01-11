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
 * Created by cspark on 2017. 1. 2..
 */
@Embeddable
@Data
public class Ratio {

    /**
     * 건폐율 (building coverage rate)
     */
    @Digits(integer = 2, fraction = 2)
    @Column(precision = 4, scale = 2, columnDefinition = "DECIMAL(4,2)")
    private Double coverage;

    /**
     * 용적율 (floor area ratio)
     */
    @Digits(integer = 2, fraction = 2)
    @Column(precision = 4, scale = 2, columnDefinition = "DECIMAL(4,2)")
    private Double floor;

}
