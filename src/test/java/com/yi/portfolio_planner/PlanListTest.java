package com.yi.portfolio_planner;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yi.domain.Exercise;
import com.yi.domain.PlanList;
import com.yi.persistence.ExerciseDao;
import com.yi.persistence.PlanDao;
import com.yi.persistence.PlanListDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class PlanListTest {
	
	@Autowired
	private PlanListDao planListDao;
	
	@Autowired
	private ExerciseDao exerciseDao;
	
	@Autowired
	private PlanDao planDao;
	
	@Test
	public void test01InsertPlanList() {
		PlanList planList = new PlanList();
		planList.setSetcnt(3);
		planList.setExec(false);
		planList.setExercise(exerciseDao.selectByEno(5));
		planList.setPlan(planDao.selectByPno(1));
		
		planListDao.insertPlanList(planList);
	}
	
	@Test
	public void test02() {
		List<PlanList> list = planListDao.selectByPno(1);
		System.out.println(list);
	}

}
