package com.yi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yi.domain.Plan;
import com.yi.service.ExerciseService;
import com.yi.service.PlanService;

@Controller
@RequestMapping("/calendar/")
public class PlanController {

	@Autowired
	private ExerciseService exerciseService;

	@Autowired
	private PlanService planService;

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
	@ResponseBody
	public Plan insertPost(@RequestParam int pno) {
		List<String> list = exerciseService.selectPartByPart();
		Plan plan = planService.selectByPno(pno);
		Map<String, Object> map = new HashMap<>();

		map.put("list", list);
		map.put("plan", plan);

		return plan;
	}

}
