package com.yi.service;

import java.util.List;

import com.yi.domain.PlanList;

public interface PlanListService {
	public void insertPlanList(PlanList planList);

	public List<PlanList> selectByPno(int pno);

}
