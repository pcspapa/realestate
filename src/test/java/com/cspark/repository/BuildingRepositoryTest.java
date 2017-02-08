/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.repository;

import com.cspark.entity.Building;
import com.cspark.entity.BuildingContact;
import com.cspark.entity.Contact;
import com.cspark.entity.address.Address;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace.NONE;

/**
 * Created by cspark on 2017. 2. 6..
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class BuildingRepositoryTest {

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    ContactRepository contactRepository;

    Building building;

    Address address;


    Contact contact;


    @Before
    public void init() {
        building = new Building();

        address = new Address();
        address.setMgtNo("1150010900101890013003638");
        address.setSggBdName("만선빌");

        contact = new Contact();
        contact.setFullname("브래트 피트");
        contact.setEmail("bradpitt@gmail.com");
        contact.setMobileNo("000-0000-0000");

    }

    @Test
    public void testFindAll() {
        List<Building> buildings = buildingRepository.findAll();
        buildings.forEach(System.out::println);


        buildings.forEach(b -> System.out.println(b.getAddress().getSggBdName()));

    }

    @Test
    public void testSaveAndAddress() {
        building.setAddress(address);

        buildingRepository.save(building);

        assertThat(building.getId(), is(notNullValue()));
    }

    @Test
    @Commit
    public void testSaveAndContact() {
        contactRepository.save(contact);

        BuildingContact buildingContact = new BuildingContact();
        buildingContact.setBuilding(building);
        buildingContact.setContact(contact);
        buildingContact.setCharge("건물주");

        building.setAddressId("1150010900101890013003638");
        building.getBuildingContacts().add(buildingContact);

        System.out.println(building);

        buildingRepository.save(building);

        building.getBuildingContacts().forEach(bc -> assertThat(bc.getId(), is(notNullValue())));
    }
}