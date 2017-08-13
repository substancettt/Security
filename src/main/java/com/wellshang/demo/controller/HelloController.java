package com.wellshang.demo.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping({"", "/"})
    @ResponseBody
    public String greeting() {
    	return "Hello, ! Now is: " + new Date();
    }
}
