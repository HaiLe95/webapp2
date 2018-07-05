package com.webapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

    /**
     *  Isn't available at the moment
     * @return
     */
    @RequestMapping(value = "/loginForm", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
}
