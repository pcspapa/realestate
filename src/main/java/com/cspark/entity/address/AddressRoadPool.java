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
import java.io.Serializable;

/**
 * Created by cspark on 2017. 2. 1..
 */
@Data
@IdClass(AddressRoadPool.AddressRoadPoolId.class)
public class AddressRoadPool {

    /**
     * 도로코드
     */
    @Id
    @Column(name = "road_code")
    @JoinColumn(name = "road_code", insertable = false, updatable = false)
    private String roadCode;

    /**
     * 읍면동일련번호
     */
    @Id
    @Column(name = "emd_sno")
    @JoinColumn(name = "emd_sno",  insertable = false, updatable = false)
    private String emdSno;

    /**
     * 도로명칭
     */
    private String roadName;

    /**
     * 도로명로마자
     */
    private String raodEname;

    /**
     * 시도명
     */
    private String sdName;

    /**
     * 시도로마자
     */
    private String sdEname;

    /**
     * 시군구명칭
     */
    private String sggName;

    /**
     * 시군구로마자
     */
    private String sggEname;

    /**
     * 읍면동명칭
     */
    private String emdName;

    /**
     * 읍면동로마자
     */
    private String emdEname;

    /**
     * 읍면동코드
     */
    private String emdCode;

    /**
     * 법정읍면동코드
     */
    private String legalEmdCode;

    /**
     * 사용여부
     */
    private boolean enabled;

    /**
     * 변경사유
     */
    private String changeCode;

    /**
     * 변경이력정보
     */
    private String changeHistory;

    /**
     * 고시일자
     */
    private String notificationDate;

    /**
     * 말소일자
     */
    private String erasureDate;


    @Data
    public static class AddressRoadPoolId implements Serializable {

        private String roadCode;

        private String emdSno;

    }
}


