package com.webapp.web.controller;


import com.webapp.web.dao.UserRepository;
import com.webapp.web.domain.User;
import org.hibernate.HibernateException;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Controller
public class QueriesController {

    private Logger log;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void initialize() {
        log = LoggerFactory.getLogger(QueriesController.class);
        log.info("Logger has been created...");
    }

    @RequestMapping(
            value = "/user/create",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(
            @RequestParam String fName,
            @RequestParam String lName,
            @RequestParam int age) {
        try {
            log.info("Preparing to create a record...");
            log.info("Person - name :" + fName + " surname: " + lName + " age: " + age);
            User user = userRepository.saveAndFlush(new User(fName, lName, age));
            log.info("The record has been created: " + user.toString());
        } catch (HibernateException ex) {
            log.error(ex.getLocalizedMessage());
            ex.printStackTrace();
        }
    }

    @RequestMapping(
            value = "person/findAll",
            method = RequestMethod.GET)
    public @ResponseBody String findAllPersons() {
        JSONArray body =
                new JSONArray(userRepository.findAll());
        return body.toString();
    }

}