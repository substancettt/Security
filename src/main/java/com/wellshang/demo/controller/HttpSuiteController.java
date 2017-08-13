package com.wellshang.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wellshang.demo.domain.HttpSuite;
import com.wellshang.demo.repository.HttpSuiteDao;

@RestController
@RequestMapping("/httpsuite")
public class HttpSuiteController {

	@Autowired
	HttpSuiteDao httpSuiteDao;

	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@RequestMapping({"", "/"})
	public ModelAndView list(Model model) {
		List<HttpSuite> HttpSuites = httpSuiteDao.findAll();
		model.addAttribute("HttpSuites", HttpSuites);
		return new ModelAndView("/httpsuite/list");
	}
	
	@RequestMapping({"newPage"})
	public ModelAndView goNewPage() {
		return new ModelAndView("/httpsuite/new");
	}
	
    @RequestMapping(value = {"postnew"}, method = RequestMethod.POST)
    @ResponseBody
    public void newOne(@RequestParam(value = "name") String name) {
    	HttpSuite httpSuite = new HttpSuite();
    	httpSuite.setName(name);
    	httpSuiteDao.save(httpSuite);
    }
}
