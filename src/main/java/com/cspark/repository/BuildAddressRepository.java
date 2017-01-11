/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.repository;

import com.cspark.entity.address.BuildAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cspark on 2017. 1. 11..
 */
public interface BuildAddressRepository extends JpaRepository<BuildAddress, Long> {

    List<BuildAddress> findByBdName(String bdName);

}
