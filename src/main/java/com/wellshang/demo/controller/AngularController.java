package com.wellshang.demo.controller;

import java.util.Date;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/angular")
public class AngularController {

    @RequestMapping("/filter")
    public ModelAndView greeting(Model model) {
    	Date now = new Date();
    	String content = "Hello, ! Now is: " + now;
    	
        return new ModelAndView(content);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public ModelAndView filter() {
        return new ModelAndView("/angular/filter");
    }
}
