/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.web;

import com.cspark.entity.Building;
import com.cspark.entity.address.Address;
import com.cspark.service.BuildingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 등록된 건물 목록을 보여준다.
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String buildings(Model model) {
        model.addAttribute("buildings", buildingService.findAll());

        return "buildings/building-list";
    }

    /**
     * 건물 등록을 위한 화면을 보여준다.
     *
     * @param building
     * @return
     */
    @RequestMapping(value = "/build", method = RequestMethod.GET)
    public String beingBuilt(Building building) {
        return "buildings/writing-building";
    }

    /**
     * 건물을 등록한다.
     *
     * @param building
     * @param bindingResult
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String build(@ModelAttribute Address address, @ModelAttribute @Valid Building building, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.warn("{}", bindingResult.getAllErrors());
            return "buildings/writing-building";
        }
        buildingService.add(building);

        return "redirect:/buildings";
    }

    /**
     * 등록된 건물을 보여준다.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String building(@PathVariable Long id, Model model) {
        model.addAttribute("building", buildingService.findOne(id));

        return "buildings/reading-building";
    }

    /**
     * 등록된 건물의 수정을 위한 화면을 보여준다.
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}/rebuild", method = RequestMethod.GET)
    public String beingRebuilt(@PathVariable Long id, Model model) {
        model.addAttribute("building", buildingService.findOne(id));

        return "buildings/editing-building";
    }

    /**
     * 등록된 건물을 수정한다.
     *
     * @param id
     * @param building
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String rebuild(@PathVariable Long id, Building building) {
        buildingService.edit(building);

        return "redirect:/buildings/" + id;
    }

}
