/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.web;

import com.cspark.entity.Building;
import com.cspark.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by cspark on 2016. 10. 21..
 */
@Controller
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    private BuildingRepository buildingRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String buildings(Model model) {
        model.addAttribute("buildings", buildingRepository.findAll());

        return "building-list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToBuildings(Building building) {
        buildingRepository.save(building);

        return "redirect:/building";
    }

}
