/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.entity.address;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * juso.go.kr의 건물DB POOL Model
 *
 * Created by cspark on 2017. 1. 11..
 */
@Entity
@Data
@NoArgsConstructor
public class BuildAddress {

    /**
     * 법정동코드
     */
    private String legalDongCode;

    /**
     * 시도명
     */
    private String sdName;

    /**
     * 시군구명
     */
    private String sggName;

    /**
     * 법정읍면동명
     */
    private String legalEmdName;

    /**
     * 법정리명
     */
    private String legalLiName;

    /**
     * 산여부
     */
    private String mountain;

    /**
     * 지번본번(번지)
     */
    private String landMainNo;

    /**
     * 지번부번(호)
     */
    private String landSubNo;

    /**
     * 도로명코드
     */
    private String rdCode;

    /**
     * 도로명
     */
    private String rdName;

    /**
     * 지하여부
     */
    private String basement;

    /**
     * 건물본번
     */
    private String bdMainNo;

    /**
     * 건물부번
     */
    private String bdSubNo;

    /**
     * 건축물대장 건물명
     */
    private String bdName;

    /**
     * 상세건물명
     */
    private String detBdName;

    /**
     * 건물관리번호
     */
    @Id
    private String bdMgtSn;

    /**
     * 읍면동일련번호
     */
    private String emdSeq;

    /**
     * 행정동코드
     */
    private String politicalDongCode;

    /**
     * 행정동명
     */
    private String politicalDongName;

    /**
     * 우편번호
     */
    private String zipCode6;

    /**
     * 우편일련번호
     */
    private String zipSeq;

    /**
     * 다량배달처명
     */
    private String massDelivery;

    /**
     * 이동사유코드
     */
    private String reasonCode;

    /**
     * 고시일자
     */
    private String notificationDate;

    /**
     * 변동전도로명주소
     */
    private String bfRdAddr;

    /**
     * 시군구용  건물명
     */
    private String sggBdName;

    /**
     * 공동주택여부
     */
    private String apartment;

    /**
     * 기초구역번호
     */
    private String zipCode5;

    /**
     * 상세주소여부
     */
    private String detAddr;

    public BuildAddress(String bdName) {
        this.bdName = bdName;
    }

}
