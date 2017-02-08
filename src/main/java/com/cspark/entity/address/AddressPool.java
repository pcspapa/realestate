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
import javax.validation.constraints.Digits;
import java.util.List;

/**
 * Created by cspark on 2017. 2. 1..
 */
@Data
@ToString
public class AddressPool {

    /**
     * 관리번호
     */
    @Id
    private String mgtNo;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "mgt_no")
    private AddressExtraPool extraPool;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "mgt_no")
    private List<AddressJibunPool> jibunPools;

    @ManyToOne
    @JoinColumns(
            foreignKey = @ForeignKey(name = "FK_ADDRESS_ROAD_POOL"),
            value = {
                    @JoinColumn(name = "road_code", referencedColumnName = "road_code", insertable = false, updatable = false),
                    @JoinColumn(name = "emd_sno", referencedColumnName = "emd_sno", insertable = false, updatable = false)
            }
    )
    private AddressRoadPool roadPool;

    /**
     * 도로코드
     */
    @Column(name = "road_code")
    private String roadCode;

    /**
     * 읍면동일련번호
     */
    @Column(name = "emd_sno")
    private String emdSno;

    /**
     * 지하여부
     */
    private boolean basement;

    /**
     * 건물본번
     */
    @Digits(integer = 5, fraction = 0)
    @Column(precision = 5)
    private Integer bdMainNo;

    /**
     * 건물부번
     */
    @Digits(integer = 5, fraction = 0)
    @Column(precision = 5)
    private Integer bdSubNo;

    /**
     * 기초구역번호
     */
    @Column(name = "ZIP5_CODE")
    private String zip5Code;

    /**
     * 변경사유코드
     */
    private String changeCode;

    /**
     * 고시일자
     */
    private String notificationDate;

    /**
     * 변경전도로명주소
     */
    private String bfRoadAddr;

    /**
     * 상세주소부여 여부
     */
    private boolean detAddr;

}
