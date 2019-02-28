package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.Plan;
import com.yi.persistence.PlanDao;

@Service
public class PlanServiceImpl implements PlanService {
	@Autowired
	private PlanDao planDao;

	@Override
	public void insert(Plan plan) {
		planDao.insert(plan);
	}

	@Override
	public void update(Plan plan) {
		planDao.update(plan);
	}

	@Override
	public void delete(int pno) {
		planDao.delete(pno);
	}

	@Override
	public Plan selectByPno(int pno) {
		return planDao.selectByPno(pno);
	}

	@Override
	public List<Plan> selectByAll(int mno) {
		return planDao.selectByAll(mno);
	}

}
