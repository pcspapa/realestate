/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.entity.building;

/**
 * Created by cspark on 2016. 11. 2..
 */

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Digits;

/**
 * 건축 규모 (Building Composition)
 *
 * @author cspark
 *
 * Created by cspark on 2015. 5. 6..
 */
@Embeddable
@Data
public class Composition {

    /**
     * 지하층 (basement floor)
     */
    @Digits(integer = 2, fraction = 0)
    @Column(precision = 2)
    private Integer basementFloor;

    /**
     * 지상층 (ground floor)
     */
    @Digits(integer = 3, fraction = 0)
    @Column(precision = 3)
    private Integer groundFloor;

    /**
     * 유형 (type)
     */
    private String type;

    @Override
    public String toString() {
        return (basementFloor == null ? "" : "지하 " + basementFloor + "층 ") + (groundFloor == null ? "" : "지상 "  + groundFloor + "층 ") + (type.isEmpty() ? "" : type);
    }
}

