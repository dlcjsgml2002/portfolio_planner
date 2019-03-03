package com.yi.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yi.domain.Exercise;
import com.yi.domain.Plan;
import com.yi.service.ExerciseService;
import com.yi.service.PlanService;

@Controller
@RequestMapping("/calendar/*")
public class CalendarController {
	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);

	@Autowired
	private ExerciseService exerciseService;
	
	@Autowired
	private PlanService planService;

	@RequestMapping(value = "month", method = RequestMethod.GET)
	public String monthGet(Model model, int mno) {
		logger.info("Month Get");

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		Date today = new Date();;
		
		List<Plan> list = planService.selectByAll(mno);

		Map<String, Object> map = new HashMap<>();
		map.put("year", year);
		map.put("month", month);
		map.put("today", today);
		map.put("list", list);

		model.addAttribute("map", map);

		return "/calendar/month";
	}

	@RequestMapping(value = "week", method = RequestMethod.GET)
	public String weekGet(Model model) {
		logger.info("Week Get");

		Date today = new Date();

		Map<String, Object> map = new HashMap<>();
		map.put("today", today);

		model.addAttribute("map", map);

		return "/calendar/week";
	}

	@RequestMapping(value = "day", method = RequestMethod.GET)
	public String dayGet(Model model) {
		logger.info("Day Get");

		Date today = new Date();
		List<String> list = exerciseService.selectPartByPart();
		List<Plan> plan = planService.selectByAll(1);

		Map<String, Object> map = new HashMap<>();
		map.put("today", today);
		map.put("list", list);
		map.put("plan", plan);

		model.addAttribute("map", map);

		return "/calendar/day";
	}
	
	@RequestMapping(value = "dayajax", method = RequestMethod.GET)
	public ResponseEntity<List<Exercise>> exerciseInfo(String part) {
		ResponseEntity<List<Exercise>> entity = null;

		try {
			List<Exercise> list = exerciseService.selectByPart(part);
			entity = new ResponseEntity<List<Exercise>>(list ,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

}
