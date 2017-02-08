/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.entity;

import com.cspark.entity.address.Address;
import com.cspark.entity.building.*;
import com.cspark.entity.core.TypeAndNote;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cspark on 2016. 10. 21..
 */
@Entity
@Data
@Getter @Setter
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(name = "ADDRESS_ID")
    private String addressId;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "MGT_NO", insertable = false, updatable = false)
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id.building", cascade=CascadeType.ALL)
    private Set<BuildingContact> buildingContacts = new HashSet<>();

    /**
     * 용도지역 (Use Zoning)
     */
    private String useZoning;

    /**
     * 용도지구 (Use District)
     */
    private String useDistrict;

    /**
     * 대지면적 (Land Area)
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "pyeong", column = @Column(name = "LAND_AREA_PY")),
            @AttributeOverride(name = "squareMeter", column = @Column(name = "LAND_AREA_M2"))
    })
    private Area landArea;

    /**
     * 연면적 (Total Floor Area)
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "pyeong", column = @Column(name = "TOTAL_FLOOR_AREA_PY")),
            @AttributeOverride(name = "squareMeter", column = @Column(name = "TOTAL_FLOOR_AREA_M2"))
    })
    private Area totalFloorArea;

    /**
     * 건축면적 (Building Area)
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "pyeong", column = @Column(name = "AREA_PY")),
            @AttributeOverride(name = "squareMeter", column = @Column(name = "AREA_M2"))
    })
    private Area area;

    /**
     * 용적율산정용연면적 (용적율 산정을 위한 연면적 : Total Floor Area For Floor Ratio)
     */
    private String totalFloorAreaForFloorRt;

    /**
     * 건축비율 (Construction Ratio)
     * - 건폐율 : coverage
     * - 용적율 : floor
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "coverage", column = @Column(name = "COVERAGE_RT")),
            @AttributeOverride(name = "floor", column = @Column(name = "FLOOR_RT"))
    })
    private Ratio ratio;

    /**
     * 구역 (boundary)
     */
    private String boundary;


    // 명칭및번호

    /**
     * 건축물수 (Main Building Count)
     */
    private Integer mainBuildingCnt;


    /**
     * 총호수.세대_수(세대) (Household Count)
     */
    private Integer householdCnt;

    /**
     * 총호수.가구_수(가구) (Family Count)
     */
    private Integer familyCnt;

    /**
     * 건물용도 (주용도 : Building Purpose)
     */
    private String purpose;

    /**
     * 주요구조 (주구조 지붕구조 : Building Structure)
     */
    private String structure;

    /**
     * 부속_건축물_수 (Attached Building Count)
     */
    private Integer attachedBuildingCnt;

    /**
     * 부속_건축물_면적(㎡) (Attached Building Area)
     */
    private Double attachedBuildingArea;

    /**
     * 허가일자 (Permission Date)
     */
    private Date permissionDate;

    /**
     * 착공일자 (Date of the start of construction work)
     */
    private Date stcnsDate;

    /**
     * 사용승인 (Approval Of Use)
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "date", column = @Column(name = "APPROVAL_DATE")),
            @AttributeOverride(name = "note", column = @Column(name = "APPROVAL_NOTE"))
    })
    private Approval approvalOfUse;

    /**
     * 주차장 (Parking)
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "inMechCnt", column = @Column(name = "PARKING_IMC")),
            @AttributeOverride(name = "inMechArea", column = @Column(name = "PARKING_IMA")),
            @AttributeOverride(name = "inAutoCnt", column = @Column(name = "PARKING_IAC")),
            @AttributeOverride(name = "inAutoArea", column = @Column(name = "PARKING_IAA")),
            @AttributeOverride(name = "outMechCnt", column = @Column(name = "PARKING_OMC")),
            @AttributeOverride(name = "outMechArea", column = @Column(name = "PARKING_OMA")),
            @AttributeOverride(name = "outAutoCnt", column = @Column(name = "PARKING_OAC")),
            @AttributeOverride(name = "outAutoArea", column = @Column(name = "PARKING_OAA"))
    })
    private Parking parking;

    /**
     * 승강기 (TypeAndNote)
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "type", column = @Column(name = "ELEVATOR_TYPE")),
            @AttributeOverride(name = "note", column = @Column(name = "ELEVATOR_NOTE"))
    })
    private TypeAndNote elevator;

    /**
     * 오수정화시설 (sewage purification facility)
     * - 형식
     */
    private String spfType;

    /**
     * 오수정화시설 (sewage purification facility)
     * - 용량
     */
    private Double spfCapacity;

    // 기타 : 관련지번









    // s.self management infomation

    /**
     * 건축규모 (Building Composition)
     *   ex. 지하 X층, 지상 XX층, CODE
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "basementFloor", column = @Column(name = "COMPOSITION_BASEMENT_FLOOR")),
            @AttributeOverride(name = "groundFloor", column = @Column(name = "COMPOSITION_GROUND_FLOOR")),
            @AttributeOverride(name = "type", column = @Column(name = "COMPOSITION_TYPE"))
    })
    private Composition composition;

    /**
     * 냉난방장치 (Air Conditioner)
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "type", column = @Column(name = "AIR_CONDITIONER_TYPE")),
            @AttributeOverride(name = "note", column = @Column(name = "AIR_CONDITIONER_NOTE"))
    })
    private TypeAndNote airConditioner;

    /**
     * 근접사거리 (Nearest Crossroad)
     */
    private String nearestCrossroad;

    /**
     * 접근도로 (Access Road)
     */
    private String accessRoad;

    /**
     * 역세권 (Subway Station Sphere)
     */
    private String subwayStationSphere;

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


    /**
     * 관리_기준층 면적 (Typical Floor Area)
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "rental.pyeong", column = @Column(name = "TYPICAL_FLOOR_RENTAL_AREA_PY")),
            @AttributeOverride(name = "rental.squareMeter", column = @Column(name = "TYPICAL_FLOOR_RENTAL_AREA_M2")),
            @AttributeOverride(name = "exclusive.pyeong", column = @Column(name = "TYPICAL_FLOOR_EXCLUSIVE_AREA_PY")),
            @AttributeOverride(name = "exclusive.squareMeter", column = @Column(name = "TYPICAL_FLOOR_EXCLUSIVE_AREA_M2")),
            @AttributeOverride(name = "exclusiveRatio", column = @Column(name = "TYPICAL_FLOOR_EXCLUSIVE_RT")),
            @AttributeOverride(name = "floorHeight", column = @Column(name = "TYPICAL_FLOOR_HEIGHT"))
    })
    private TypicalFloorArea typicalFloorArea;

    /**
     * 관리_수수료 (Commission)
     */
    private String commission;

    /**
     * 관리_임대료 산정방식 (Rent Calculation Method)
     */
    private String rentCalculation;

    /**
     * 관리_관리비 (Maintenance Fee)
     */
    private String maintenanceFee;

    /**
     * 관리_보증금 비율 (Deposit Rate)
     */
    private String depositRate;

    /**
     * 관리_관리 항목 (Maintenance Item)
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "type", column = @Column(name = "MAINTENANCE_ITEM_TYPE")),
            @AttributeOverride(name = "note", column = @Column(name = "MAINTENANCE_ITEM_NOTE"))
    })
    private TypeAndNote maintenanceItem;

    /**
     * 관리_주차비용 (Parking Fee)
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "free", column = @Column(name = "PARKING_FEE_FREE")),
            @AttributeOverride(name = "paid", column = @Column(name = "PARKING_FEE_PAID"))
    })
    private ParkingFee parkingFee;

    /**
     * 관리_근무시간 (Work Hour)
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "type", column = @Column(name = "WORK_HOUR_TYPE")),
            @AttributeOverride(name = "note", column = @Column(name = "WORK_HOUR_NOTE"))
    })
    private TypeAndNote workHour;

    /**
     * 관리_기피업종 (Avoided Tenant)
     */
    private String avoidedTenant;

    /**
     * 관리_전속물건 (Exclusive)
     */
    private String exclusive;

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
