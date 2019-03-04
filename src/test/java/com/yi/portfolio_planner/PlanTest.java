package com.yi.portfolio_planner;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yi.domain.Plan;
import com.yi.persistence.MemberDao;
import com.yi.persistence.PlanDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class PlanTest {
	
	@Autowired
	private PlanDao planDao;
	
	@Autowired
	private MemberDao memberDao;
	
	/*@Test
	public void test01Insert() {
		Plan plan = new Plan();
		plan.setMember(memberDao.read("user01", "passward"));
		plan.setTitle("플랜 이름");
		plan.setStartdate(new Date(2019, 2, 27));
		plan.setEnddate(new Date(2017, 02, 28));
		
		planDao.insert(plan);
		System.out.println(plan);
	}
	
	@Test
	public void test02Read() {
		System.out.println(planDao.selectByPno(1));
		Plan plan = new Plan();
		plan = planDao.selectByPno(1);
		System.out.println(plan);
	}*/
	
	@Test
	public void test03SelectByAll() {
		System.out.println(planDao.selectByAll(1));
	}

}
