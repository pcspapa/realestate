/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.service;

import com.cspark.entity.Contact;

import java.util.List;

/**
 * Created by cspark on 2016. 12. 13..
 */
public interface ContactService {

    List<Contact> findAll();

    Contact findOne(Long id);

    void add(Contact contact);

    void edit(Contact contact);
}
