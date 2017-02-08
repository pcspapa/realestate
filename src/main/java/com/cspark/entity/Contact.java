/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.entity;

import com.cspark.validation.constraints.ByteLength;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @ByteLength(min = 4, max = 50)
    private String fullname;

    /**
     * one's position (in an organization).
     */
    private String position;

    private String gender;

    private String typeOfEnterprise;

    private String typeOfIndustry;

    private String companyName;

    private String deptName;

    @NotBlank
    @Email
    private String email;

    @Pattern(regexp = "[0-9]{3}-[0-9]{3,4}-[0-9]{4}")
    private String mobileNo;

    @Pattern(regexp = "([0-9]{2,3}-[0-9]{3,4}-[0-9]{4})?")
    private String phoneNo;

    @Pattern(regexp = "([0-9]{2,3}-[0-9]{3,4}-[0-9]{4})?")
    private String faxNo;

    private String address;

    private String note;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id.contact")
    private Set<BuildingContact> buildingContacts = new HashSet<>();

}