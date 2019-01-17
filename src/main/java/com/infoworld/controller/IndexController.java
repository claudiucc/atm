package com.infoworld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Claudiu on 01/17/2018.
 */
@Controller
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("index");
        return model;
    }

    @RequestMapping(value = "/bank", method = RequestMethod.GET)
    public ModelAndView getAmount(@RequestParam("amount") Integer amount) {
        ModelAndView model = new ModelAndView("index");
        System.out.println(amount);
        return model;
    }
}
