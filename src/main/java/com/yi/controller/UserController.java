package com.yi.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yi.domain.Login;
import com.yi.domain.Member;
import com.yi.service.MemberService;

@Controller
@RequestMapping("/user/*")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private MemberService service;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void loginGet() {
		logger.info("login Get ----------");
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public void loginPost(String id, String pw, Model model) {
		logger.info("login Post ----------");
		Member member = service.read(id, pw);
		
		if (member == null) {
			logger.info("loginPost return ...... ");
		}
		
		Login login = new Login();
		login.setId(member.getId());
		login.setName(member.getName());
		
		model.addAttribute("member", login);
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logOutGet(HttpSession session) {
		logger.info("logout Get ----------");
		session.invalidate();
		
		return "redirect:/board/list";
	}

}
