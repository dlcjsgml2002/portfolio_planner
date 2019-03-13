package com.yi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.yi.domain.PlanList;
import com.yi.service.ExerciseService;
import com.yi.service.MemberService;
import com.yi.service.PlanService;

@Controller
@RequestMapping("/plan/")
public class PlanController {
	private static final Logger logger = LoggerFactory.getLogger(PlanController.class);

	@Autowired
	private PlanService planService;
	
	@Autowired
	private ExerciseService exerciseService;
	
	@Autowired
	private MemberService memberService;

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
		
		List<String> list = exerciseService.selectPartByPart();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);

		model.addAttribute("map", map);

		return "/plan/insert";
	}
	
	@RequestMapping(value = "exercise_ajax", method = RequestMethod.GET)
	public ResponseEntity<List<Exercise>> exerciseInfo(String part) {
		ResponseEntity<List<Exercise>> entity = null;

		try {
			List<Exercise> list = exerciseService.selectByPart(part);
			entity = new ResponseEntity<List<Exercise>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertPost(HttpSession session, int mno, String title, int[] eno, int[] execnt, int[] setcnt) {
		Plan plan = new Plan();
		plan.setTitle(title);
		plan.setMember(memberService.selectByMno(mno));
		planService.insert(plan);

		for (int i = 0; i < eno.length; i++) {
			PlanList planList = new PlanList();
			planList.setPlan(plan);
			planList.setExercise(exerciseService.selectByEno(eno[i]));
			planList.setExecnt(execnt[i]);
			planList.setSetcnt(setcnt[i]);
			planService.insertPlanList(planList);
		}

		return "redirect:/plan/list";
	}
	
	@RequestMapping(value = "remove_ajax", method = RequestMethod.GET)
	public ResponseEntity<Plan> removePlan(int pno) {
		ResponseEntity<Plan> entity = null;

		try {
			planService.removePlanList(pno);
			planService.removePlanDate(pno);
			planService.delete(pno);
			
			entity = new ResponseEntity<Plan>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	@RequestMapping(value = "plan_list", method = RequestMethod.GET)
	public ResponseEntity<List<Plan>> plan_list(int mno) {
		ResponseEntity<List<Plan>> entity = null;

		try {
			List<Plan> plan =  planService.selectByAll(mno);
			
			entity = new ResponseEntity<List<Plan>>(plan, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

}
