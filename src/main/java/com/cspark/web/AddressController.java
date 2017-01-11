/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.web;

import com.cspark.entity.address.BuildAddress;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cspark on 2017. 1. 11..
 */
@RestController
@RequestMapping("/addresses")
public class AddressController {

    @RequestMapping
    public List<BuildAddress> addresses(@RequestParam(name = "bdName") String bdName) {
        List<BuildAddress> bdList = new ArrayList<>();
        bdList.add(new BuildAddress("만선빌1"));
        bdList.add(new BuildAddress("만선빌2"));
        bdList.add(new BuildAddress("만선빌3"));

        return bdList;
    }
}
