/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.service;

import com.cspark.entity.Building;
import com.cspark.entity.address.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by cspark on 2017. 2. 6..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BuildingServiceTest {

    @Autowired
    BuildingService buildingService;

    Building building;

    Address address;


    /**
     * insert into building
     */
    @Test
    public void testAddWithAddressId() {
        building = new Building();
        building.setAddressId("1150010900101890013003638");

        buildingService.add(building);

        assertThat(building.getId(), is(notNullValue()));
    }

    /**
     * insert into building
     */
    @Test
    public void testAddWithAddressIdAndAddress() {
        address = new Address();
        address.setMgtNo("1150010900101890013003638");

        building = new Building();
        building.setAddressId("1150010900101890013003638");
        building.setAddress(address);

        buildingService.add(building);

        assertThat(building.getId(), is(notNullValue()));
    }


}