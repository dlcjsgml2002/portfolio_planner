package com.yi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yi.domain.Exercise;
import com.yi.domain.Login;
import com.yi.domain.Plan;
import com.yi.domain.PlanList;
import com.yi.service.ExerciseService;
import com.yi.service.PlanService;

@Controller
@RequestMapping("/plan/")
public class PlanController {
	private static final Logger logger = LoggerFactory.getLogger(PlanController.class);

	@Autowired
	private PlanService planService;
	
	@Autowired
	private ExerciseService exerciseService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String listGet(Model model, HttpSession session) {
		logger.info("list Get");

		Login login = (Login) session.getAttribute("login");
		int mno = login.getMno();
		List<Plan> plan = planService.selectByAll(mno);
		System.out.println(plan);

		model.addAttribute("plan", plan);

		return "/plan/list";
	}
	
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public String readGet(Model model, HttpSession session, int pno) {
		logger.info("list Get");
		
		Plan plan = planService.selectByPno(pno);
		System.out.println("plan : " + plan);
		
		List<PlanList> planList = planService.selectPlanListByPno(pno);
		plan.setPlanList(planList);
		System.out.println("planList : " + planList);
		
		model.addAttribute("plan", plan);

		return "/plan/read";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insertGet(Model model, HttpSession session) {
		logger.info("list Get");

		return "/plan/insert";
	}

}
