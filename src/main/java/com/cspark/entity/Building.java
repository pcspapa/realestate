/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.entity;

import com.cspark.entity.building.Area;
import com.cspark.entity.building.Composition;
import com.cspark.entity.building.Elevator;
import com.cspark.entity.building.Ratio;
import com.cspark.validation.constraints.ByteLength;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Created by cspark on 2016. 10. 21..
 */
@Entity
@Data
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 이름 (Building Name)
     */
    @ByteLength(min = 4, max = 100)
    private String name;

    /**
     * 주소 (address)
     * - 도로명 주소 표현.
     */
    @NotBlank
    private String address;

    /**
     * 대지면적 (Land Area)
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="pyeong", column=@Column(name="LAND_AREA_PY")),
            @AttributeOverride(name="squareMeter", column=@Column(name="LAND_AREA_M2"))
    })
    private Area landArea;

    /**
     * 연면적 (Total Floor Area)
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="pyeong", column=@Column(name="TOTAL_FLOOR_AREA_PY")),
            @AttributeOverride(name="squareMeter", column=@Column(name="TOTAL_FLOOR_AREA_M2"))
    })
    private Area totalFloorArea;

    /**
     * 건축규모 (Building Composition)
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="basementFloor", column=@Column(name="COMPOSITION_BASEMENT_FLOOR")),
            @AttributeOverride(name="groundFloor", column=@Column(name="COMPOSITION_GROUND_FLOOR")),
            @AttributeOverride(name="type", column=@Column(name="COMPOSITION_TYPE"))
    })
    private Composition composition;

    /**
     * 건물용도 (Building Purpose)
     */
    private String purpose;

    /**
     * 주요구조 (Building Structure)
     */
    private String structure;

    /**
     * 도시계획 (Urban Planning)
     */
    private String urbanPlanning;

    /**
     * 건축면적 (Building Area)
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="coverage", column=@Column(name="COVERAGE_RT")),
            @AttributeOverride(name="floor", column=@Column(name="FLOOR_RT"))
    })
    private Area area;

    /**
     * 사용승인 (Approval Of Use)
     */
    private String approvalOfUse;

    /**
     * 건축비율 (Construction Ratio)
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="pyeong", column=@Column(name="AREA_PY")),
            @AttributeOverride(name="squareMeter", column=@Column(name="AREA_M2"))
    })
    private Ratio ratio;

    /**
     * 승강기 (Elevator)
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="type", column=@Column(name="ELEVATOR_TYPE")),
            @AttributeOverride(name="note", column=@Column(name="ELEVATOR_NOTE"))
    })
    private Elevator elevator;

    /**
     * 주차방식 (Parking Facility)
     */
    private String parkingFacility;

    /**
     * 냉난방방식 (Air Conditioning System)
     */
    private String airConditioningSystem;

    /**
     * 근접사거리 (Nearest Crossroads)
     */
    private String nearestCrossroads;

    /**
     * 접근도로 (Access Road)
     */
    private String accessRoad;

    /**
     * 역세권 (Subway Station Sphere)
     */
    private String subwayStationSphere;

    /**
     * 건물구분 (Building Classification)
     */
    private String classification;

    /**
     * 건물사진 (Building Image)
     */
    private String image;

    /**
     * 평면도 (Floor Plan)
     */
    private String floorPlan;

    /**
     * 위치도 (Location Map)
     */
    private String locationMap;

    /**
     * 특징(광고) (Feature)
     */
    private String feature;

    /**
     * 비고 (Note)
     */
    private String note;


}
