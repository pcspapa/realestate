/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.repository;

import com.cspark.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cspark on 2016. 10. 21..
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {

}