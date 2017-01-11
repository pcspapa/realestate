/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.web;

import com.cspark.entity.Building;
import com.cspark.entity.Contact;
import com.cspark.repository.BuildingRepository;
import com.cspark.service.BuildingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by cspark on 2016. 10. 21..
 */
@Controller
@RequestMapping("/buildings")
public class BuildingController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingController.class);

    @Autowired
    private BuildingService buildingService;

    @RequestMapping(method = RequestMethod.GET)
    public String buildings(Model model) {
        model.addAttribute("buildings", buildingService.findAll());

        return "buildings/building-list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToBuildings(@ModelAttribute @Valid Building building, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.warn("{}", bindingResult.getAllErrors());
            return "buildings/writing-building";
        }
        buildingService.add(building);

        return "redirect:/buildings";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String building(Building building) {
        return "buildings/writing-building";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String building(@PathVariable Long id, Model model) {
        model.addAttribute("building", buildingService.findOne(id));

        return "buildings/reading-building";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String editToBuildings(@PathVariable Long id, Building building) {
        buildingService.edit(building);

        return "contacts/reading-contact";
    }

}
