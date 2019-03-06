package com.yi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yi.domain.Plan;
import com.yi.domain.PlanDate;
import com.yi.domain.PlanList;
import com.yi.service.ExerciseService;
import com.yi.service.MemberService;
import com.yi.service.PlanListService;
import com.yi.service.PlanService;

@Controller
@RequestMapping("/calendar/")
public class PlanController {

	@Autowired
	private ExerciseService exerciseService;

	@Autowired
	private PlanService planService;
	
	@Autowired
	private PlanListService planListService;

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public void listGet(@RequestParam int pno, Model model, int mno) {
		List<Plan> list = planService.selectByAll(1);
		Map<String, Object> map = new HashMap<>();
		System.out.println(list);

		map.put("list", list);

		model.addAttribute("map", map);
	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	@ResponseBody
	public Plan insertGet(@RequestParam int pno) {
		Plan plan = planService.selectByPno(pno);
		List<String> list = exerciseService.selectPartByPart();
		Map<String, Object> map = new HashMap<>();

		map.put("list", list);
		map.put("plan", plan);

		return plan;
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertPost(HttpSession session, int mno, String title, int[] eno, int[] setcnt, Date date) {
		System.out.println(date);
		Plan plan = new Plan();
		plan.setTitle(title);
		plan.setMember(memberService.selectByMno(mno));
		planService.insert(plan);
		
		for (int i = 0; i < eno.length; i++) {
			PlanList planList = new PlanList();
			planList.setPlan(plan);
			planList.setExercise(exerciseService.selectByEno(eno[i]));
			planList.setSetcnt(setcnt[i]);
			planListService.insertPlanList(planList);
		}
		
		PlanDate planDate = new PlanDate();
		planDate.setPlan(plan);
		planDate.setAppDate(date);
		planService.insertPlanDate(planDate);
		
		return "redirect:/calendar/day";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	@ResponseBody
	public Plan updateGet(@RequestParam int pno) {
		Plan plan = planService.selectByPno(pno);
		List<String> list = exerciseService.selectPartByPart();
		Map<String, Object> map = new HashMap<>();

		map.put("list", list);
		map.put("plan", plan);

		return plan;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public Plan updatePost(@RequestParam int pno) {
		List<String> list = exerciseService.selectPartByPart();
		Plan plan = planService.selectByPno(pno);
		Map<String, Object> map = new HashMap<>();

		map.put("list", list);
		map.put("plan", plan);

		return plan;
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	@ResponseBody
	public Plan deleteGet(@RequestParam int pno) {
		Plan plan = planService.selectByPno(pno);
		List<String> list = exerciseService.selectPartByPart();
		Map<String, Object> map = new HashMap<>();

		map.put("list", list);
		map.put("plan", plan);

		return plan;
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public Plan deletePost(@RequestParam int pno) {
		List<String> list = exerciseService.selectPartByPart();
		Plan plan = planService.selectByPno(pno);
		Map<String, Object> map = new HashMap<>();

		map.put("list", list);
		map.put("plan", plan);

		return plan;
	}

}
