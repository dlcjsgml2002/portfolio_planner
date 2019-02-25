package com.yi.persistence;

import java.util.List;

import com.yi.domain.Plan;

public interface PlanDao {
	public void insert();
	
	public Plan read();

	public void update();

	public void delete();

	public List<Plan> selectAll();

}
