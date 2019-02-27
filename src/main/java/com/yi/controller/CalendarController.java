package com.yi.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yi.domain.Exercise;
import com.yi.service.ExerciseService;

@Controller
@RequestMapping("/calendar/*")
public class CalendarController {
	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);

	@Autowired
	private ExerciseService exerciseService;

	@RequestMapping(value = "month", method = RequestMethod.GET)
	public String monthGet(Model model) {
		logger.info("Month Get");

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		Date today = new Date();

		Map<String, Object> map = new HashMap<>();
		map.put("year", year);
		map.put("month", month);
		map.put("today", today);

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
		List<Exercise> list = exerciseService.selectByAll();

		Map<String, Object> map = new HashMap<>();
		map.put("today", today);
		map.put("list", list);

		model.addAttribute("map", map);

		return "/calendar/day";
	}

}
