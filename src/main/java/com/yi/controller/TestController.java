package com.yi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping(value = "loginForm", method = RequestMethod.GET)
	public String loginForm() {

		return "loginForm";
	}
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test() {

		return "test";
	}
	
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main() {

		return "main";
	}
	
}
