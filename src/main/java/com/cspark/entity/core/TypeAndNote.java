/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.entity.core;

import lombok.Data;

import javax.persistence.Embeddable;

/**
 * Created by cspark on 2017. 1. 2..
 */
@Embeddable
@Data
public class TypeAndNote {

    /**
     * 유형 (type)
     */
    private String type;

    /**
     * 비고 (note)
     */
    private String note;
}
