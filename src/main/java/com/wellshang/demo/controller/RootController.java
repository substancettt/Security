package com.wellshang.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootController {
	@RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public ModelAndView about() {
    	return new ModelAndView("/about");
    }
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView home() {
    	return new ModelAndView("/home");
    }
}
