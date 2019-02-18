package com.yi.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/calendar/*")
public class CalendarController {
	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);

	@RequestMapping(value = "cal", method = RequestMethod.GET)
	public String calandar() {
		return "/calendar/cal";
	}

	@RequestMapping(value = "calendar", method = RequestMethod.GET)
	public String calandarGet(Model model) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
		Date today = new Date();
		int last = cal.getActualMaximum(Calendar.DATE);

		Map<String, Object> map = new HashMap<>();
		map.put("year", year);
		map.put("month", month);
		map.put("date", date);
		map.put("dayOfWeek", dayOfWeek);
		map.put("today", today);
		map.put("last", last);

		model.addAttribute("map", map);

		return "/calendar/calendar";
	}

}
