package com.yi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yi.domain.Exercise;
import com.yi.domain.Login;
import com.yi.domain.Plan;
import com.yi.domain.PlanDate;
import com.yi.domain.PlanList;
import com.yi.service.ExerciseService;
import com.yi.service.MemberService;
import com.yi.service.PlanService;

@Controller
@RequestMapping("/calendar/*")
public class CalendarController {
	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);

	@Autowired
	private ExerciseService exerciseService;

	@Autowired
	private PlanService planService;
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "month", method = RequestMethod.GET)
	public String monthGet(Model model, int mno) {
		logger.info("Month Get");

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		Date today = new Date();

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
	public String dayGet(Model model, HttpSession session, String time) throws ParseException {
		logger.info("Day Get");

		Date today = null;
		if (time != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date appDate = sdf.parse(time);
			today = appDate;
		} else {
			today = new Date();
		}

		Login login = (Login) session.getAttribute("login");
		int mno = login.getMno();
		List<String> list = exerciseService.selectPartByPart();
		List<Plan> plan = planService.selectByAll(mno);
		for (Plan p : plan) {
			List<PlanList> planList = planService.selectPlanListByPno(p.getPno());
			p.setPlanList(planList);
		}

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
			entity = new ResponseEntity<List<Exercise>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "dateajax", method = RequestMethod.GET)
	public ResponseEntity<List<PlanDate>> planInfo(int mno, String time) throws ParseException {
		ResponseEntity<List<PlanDate>> entity = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date appDate = sdf.parse(time);
		System.out.println("mno : " + mno + " time : " + time);

		try {
			List<PlanDate> planDateList = planService.selectPlanByAppDate(mno, appDate);
			for (PlanDate pd : planDateList) {
				Plan plan = planService.selectByPno(pd.getPlan().getPno());
				pd.setPlan(plan);
				System.out.println(plan);
				List<PlanList> planList = planService.selectPlanListByPno(plan.getPno());
				plan.setPlanList(planList);
				for (PlanList pl : planList) {
					Exercise exercise = exerciseService.selectByEno(pl.getExercise().getEno());
					System.out.println(exercise);
				}
				System.out.println(planList);
			}
			System.out.println(planDateList);

			entity = new ResponseEntity<List<PlanDate>>(planDateList, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "testajax", method = RequestMethod.POST)
	public ResponseEntity<PlanDate> listAppend(int pno, String date) throws ParseException {
		ResponseEntity<PlanDate> entity = null;
		System.out.println("pno : " + pno + ", date : " + date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date appDate = sdf.parse(date);
		System.out.println("appDate : " + appDate);

		try {
			Plan plan = new Plan();
			plan.setPno(pno);
			System.out.println("plan : " + plan);

			PlanDate planDate = new PlanDate();
			planDate.setPlan(plan);
			planDate.setAppDate(appDate);
			System.out.println("planDate : " + planDate);

			planService.insertPlanDate(planDate);

			entity = new ResponseEntity<PlanDate>(planDate, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "monthajax", method = RequestMethod.GET)
	public ResponseEntity<List<PlanDate>> monthDate(int mno, String month) throws ParseException {
		ResponseEntity<List<PlanDate>> entity = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date startDate = sdf.parse(month);
		Date endDate = sdf.parse(month);
		startDate.setDate(1);
		endDate.setMonth(endDate.getMonth() + 1);
		endDate.setDate(endDate.getDate() - 1);
		System.out.println("mno : " + mno);
		System.out.println("startDate : " + startDate);
		System.out.println("endDate : " + endDate);

		try {
			List<PlanDate> planDateList = planService.selectPlanDateByMonth(mno, startDate, endDate);
			for (PlanDate pd : planDateList) {
				Plan plan = planService.selectByPno(pd.getPlan().getPno());
				pd.setPlan(plan);
			}

			entity = new ResponseEntity<List<PlanDate>>(planDateList, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<List<PlanDate>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	// 그날 계획 성공여부
	@RequestMapping(value = "updateajax", method = RequestMethod.GET)
	public ResponseEntity<PlanDate> updateajax(int pdno) throws ParseException {
		ResponseEntity<PlanDate> entity = null;
		System.out.println("pdno" + pdno);

		try {
			PlanDate planDate = planService.selectPlanDate(pdno);
			System.out.println(planDate);
			System.out.println(planDate.isExecute());
			planDate.setExecute(!planDate.isExecute());
			System.out.println(planDate.isExecute());
			planService.updatePlanDate(planDate);

			entity = new ResponseEntity<PlanDate>(planDate, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<PlanDate>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	// 그날 계획 삭제
	@RequestMapping(value = "removeajax", method = RequestMethod.GET)
	public ResponseEntity<PlanDate> removeajax(int pdno) throws ParseException {
		ResponseEntity<PlanDate> entity = null;
		System.out.println("pdno : " + pdno);

		try {
			PlanDate planDate = planService.selectPlanDate(pdno);
			planService.deletePlanDate(planDate);

			entity = new ResponseEntity<PlanDate>(planDate, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<PlanDate>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "update_ajax", method = RequestMethod.GET)
	public ResponseEntity<Plan> update_ajax(int pno) {
		ResponseEntity<Plan> entity = null;
		System.out.println("pno : " + pno);

		try {
			Plan plan = planService.selectByPno(pno);
			System.out.println("plan : " + plan);
			List<PlanList> planList = planService.selectPlanListByPno(pno);
			System.out.println("planList : " + planList);
			
			plan.setPlanList(planList);

			entity = new ResponseEntity<Plan>(plan, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<Plan>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
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
	public String insertPost(HttpSession session, int mno, String title, int[] eno, int[] execnt, int[] setcnt,
			Date date) {
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
