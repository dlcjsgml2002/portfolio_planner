package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.PlanList;
import com.yi.persistence.PlanListDao;

@Service
public class PlanListServiceImpl implements PlanListService {
	
	@Autowired
	private PlanListDao planListDao;


	@Override
	public void insertPlanList(PlanList planList) {
		// TODO Auto-generated method stub
		planListDao.insertPlanList(planList);
	}

	@Override
	public List<PlanList> selectByPno(int pno) {
		// TODO Auto-generated method stub
		return planListDao.selectByPno(pno);
	}

}
