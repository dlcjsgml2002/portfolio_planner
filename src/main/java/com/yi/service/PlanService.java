package com.yi.service;

import java.util.Date;
import java.util.List;

import com.yi.domain.Plan;
import com.yi.domain.PlanDate;

public interface PlanService {
	public void insert(Plan plan);

	public void update(Plan plan);

	public void delete(int pno);

	public Plan selectByPno(int pno);

	public List<Plan> selectByAll(int mno);
	
	public List<PlanDate> insertPlanDate(PlanDate planDate);
	
	public List<PlanDate> selectPlanDateByAppDate(Date appDate);
	
	public List<PlanDate> selectPlanByAppDate(int mno, Date appDate);

}
