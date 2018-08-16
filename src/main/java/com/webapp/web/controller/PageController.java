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

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String formPage() { return "form"; }

    @RequestMapping(value = "/backForm", method = RequestMethod.GET)
    public String backendFormPage() { return "backend_form"; }
}
