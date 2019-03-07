package com.yi.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.Plan;
import com.yi.domain.PlanDate;

@Repository
public class PlanDaoImpl implements PlanDao {
	private static final String namespace = "com.yi.mapper.PlanMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(Plan plan) {
		sqlSession.insert(namespace + ".insertPlan", plan);
	}

	@Override
	public void update(Plan plan) {
		sqlSession.update(namespace + ".updatePlan", plan);
	}

	@Override
	public void delete(int pno) {
		sqlSession.delete(namespace + ".deletePlan", pno);
	}

	@Override
	public Plan selectByPno(int pno) {
		return sqlSession.selectOne(namespace + ".selectPlanByPno", pno);
	}

	@Override
	public List<Plan> selectByAll(int mno) {
		return sqlSession.selectList(namespace + ".selectPlanByAll", mno);
	}

	@Override
	public List<PlanDate> insertPlanDate(PlanDate planDate) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".insertPlanDate", planDate);
	}

	@Override
	public List<PlanDate> selectPlanDateByAppDate(Date appDate) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".selectPlanDateByAppDate", appDate);
	}

	@Override
	public List<PlanDate> selectPlanByAppDate(int mno, Date appDate) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("mno", mno);
		map.put("appDate", appDate);
		
		return sqlSession.selectList(namespace + ".selectPlanByAppDate", map);
	}

}
