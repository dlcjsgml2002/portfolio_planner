package com.yi.persistence;

import java.util.List;

import com.yi.domain.Plan;

public interface PlanDao {
	public void insertPlan(Plan plan);

	public Plan selectPlan(int pno);

	public void updatePlan(Plan plan);

	public void deletePlan(int pno);

	public List<Plan> selectPlanAll();

}
