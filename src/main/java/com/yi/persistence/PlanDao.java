package com.yi.persistence;

import java.util.List;

import com.yi.domain.Plan;

public interface PlanDao {
	public void insert(Plan plan);

	public void update(Plan plan);

	public void delete(int pno);

	public Plan selectByPno(int pno);

	public List<Plan> selectByAll(int mno);

}
