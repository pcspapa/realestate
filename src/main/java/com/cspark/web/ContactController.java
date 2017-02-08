/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cspark.web;

import com.cspark.entity.Contact;
import com.cspark.service.ContactService;
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
@RequestMapping("/contacts")
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.GET)
    public String contacts(Model model) {
        model.addAttribute("contacts", contactService.findAll());

        return "contacts/contact-list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToContacts(@ModelAttribute @Valid Contact contact, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.warn("{}", bindingResult.getAllErrors());
            return "contacts/writing-contact";
        }
        contactService.add(contact);

        return "redirect:/contacts";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String contact(Contact contact) {
        return "contacts/writing-contact";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String contact(@PathVariable Long id, Model model) {
        model.addAttribute("contact", contactService.findOne(id));

        return "contacts/reading-contact";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String editToContacts(@PathVariable Long id, Contact contact) {
        contactService.edit(contact);

        return "contacts/reading-contact";
    }

}
