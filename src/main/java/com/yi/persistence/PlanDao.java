package com.yi.persistence;

import java.util.Date;
import java.util.List;

import com.yi.domain.Plan;
import com.yi.domain.PlanDate;
import com.yi.domain.PlanList;

public interface PlanDao {
	public void insert(Plan plan);

	public void update(Plan plan);

	public void delete(int pno);

	public Plan selectByPno(int pno);

	public List<Plan> selectByAll(int mno);

	public void insertPlanList(PlanList planList);

	public List<PlanList> selectPlanListByPno(int pno);

	public List<PlanDate> insertPlanDate(PlanDate planDate);

	public List<PlanDate> selectPlanDateByAppDate(Date appDate);

	public List<PlanDate> selectPlanByAppDate(int mno, Date appDate);

	public List<PlanDate> selectPlanDateByMonth(int mno, Date startDate, Date endDate);

	public void updatePlanDate(PlanDate planDate);

	public void deletePlanDate(PlanDate planDate);
	
	public PlanDate selectPlanDate(int pdno);
	
	public void removePlanList(int pno);
	
	public void removePlanDate(int pno);

}
