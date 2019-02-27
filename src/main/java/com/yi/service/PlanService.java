package com.yi.service;

import java.util.List;

import com.yi.domain.Plan;

public interface PlanService {
	public void insert(Plan plan);

	public void update(Plan plan);

	public void delete(int pno);

	public Plan selectByPno(int pno);

	public List<Plan> selectByAll();

}
