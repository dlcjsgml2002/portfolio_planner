package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.Plan;

@Repository
public class PlanDaoImpl implements PlanDao {
	private static final String namespace = "com.yi.mapper.PlanMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertPlan(Plan plan) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertPlan", plan);
	}

	@Override
	public Plan selectPlan(int pno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".selectPlan", pno);
	}

	@Override
	public void updatePlan(Plan plan) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".updatePlan", plan);
	}

	@Override
	public void deletePlan(int pno) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".deletePlan", pno);
	}

	@Override
	public List<Plan> selectPlanAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".selectPlanAll");
	}

}
