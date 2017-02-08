/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.repository;

import com.cspark.entity.address.Address;
import com.cspark.entity.address.Address;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by cspark on 2017. 2. 1..
 */
public interface AddressRepository extends Repository<Address, String> {

    List<Address> findBySggBdNameContaining(String sggBdName);
}
