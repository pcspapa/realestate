/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.entity.address;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Created by cspark on 2017. 2. 1..
 */
@Entity(name = "ADDRESS_VIEW")
@Immutable
@Data
public class Address {

    /** 관리번호 */
    @Id
    @Column(name = "MGT_NO")
    private String mgtNo;

    /** 도로코드 */
    private String roadCode;

    /** 읍면동일련번호 */
    private String emdSno;

    /** 지하여부 */
    private boolean basement;

    /** 건물본번 */
    private Integer bdMainNo;

    /** 건물부번 */
    private Integer bdSubNo;

    /** 기초구역번호 */
    @Column(name = "ZIP5_CODE")
    private String zip5Code;

    /** 행정동명칭 */
    private String politicalDongName;

    /** 시군구건물명칭 */
    private String sggBdName;

    /** 공동주택여부 */
    private boolean apartment;

    /** 도로명칭 */
    private String roadName;

    /** 시도명칭 */
    private String sdName;

    /** 시군구명칭 */
    private String sggName;

    /** 읍면동명칭 */
    private String emdName;


    public String getBdNo() {
        return Stream.of(bdMainNo, bdSubNo)
                .filter(s -> s != null)
                .map(x -> x.toString())
                .collect(joining("-"));
    }

    public String getShortRoad() {
        return Stream.of(roadName, getBdNo())
                .filter(s -> s != null && !s.isEmpty())
                .collect(joining(" "));
    }

    public String getRoad() {
        return Stream.of(sdName, sggName, getShortRoad())
                .filter(s -> s != null && !s.isEmpty())
                .collect(joining(" "));
    }

    public String getFullRoad() {
        return Stream.of(getRoad(), getAssistant())
                .filter(s -> s != null && !s.isEmpty())
                .collect(joining(" "));
    }

    public String getAssistant() {
        return Stream.of(emdName, sggBdName)
                .filter(s -> s != null && !s.isEmpty())
                .collect(joining(", ", "(", ")"));
    }



}
