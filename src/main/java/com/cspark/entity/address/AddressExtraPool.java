/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.entity.address;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by cspark on 2017. 2. 1..
 */
@Data
@ToString
public class AddressExtraPool {

    /**
     * 관리번호
     */
    @Id
    private String mgtNo;

    /**
     * 행정동코드
     */
    private String politicalDongCode;

    /**
     * 행정동명칭
     */
    private String politicalDongName;

    /**
     * 우편번호
     */
    @Column(name = "ZIP5_CODE")
    private String zip5Code;

    /**
     * 우편번호일련번호
     */
    private String zipSno;

    /**
     * 다량배달처명
     */
    private String massAddresseeName;

    /**
     * 건축물대장건물명칭
     */
    private String bdName;

    /**
     * 시군구건물명칭
     */
    private String sggBdName;

    /**
     * 공동주택여부
     */
    private boolean apartment;

}

