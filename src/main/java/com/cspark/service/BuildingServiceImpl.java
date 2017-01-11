/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.service;

import com.cspark.entity.Building;
import com.cspark.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cspark on 2017. 1. 2..
 */
@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public List<Building> findAll() {
        return buildingRepository.findAll();
    }

    @Override
    public Building findOne(Long id) {
        return buildingRepository.findOne(id);
    }

    @Override
    public void add(Building building) {
        buildingRepository.save(building);
    }

    @Override
    public void edit(Building building) {
        buildingRepository.save(building);
    }
}
