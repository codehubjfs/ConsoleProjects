package com.hallbookingmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewBlogs {
	
	@RequestMapping(value = "/blogs", method = RequestMethod.GET)
	public ModelAndView viewBlogs(ModelAndView model) {
		model.setViewName("blogs");
		return model;
	}
}
