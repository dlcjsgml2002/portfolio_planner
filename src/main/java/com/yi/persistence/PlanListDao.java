package com.yi.persistence;

import java.util.List;

import com.yi.domain.PlanList;

public interface PlanListDao {
	public void insertPlanList(PlanList planList);

	public List<PlanList> selectByPno(int pno);

}
