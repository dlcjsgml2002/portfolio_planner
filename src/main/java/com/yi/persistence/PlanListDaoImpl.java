package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.PlanList;

@Repository
public class PlanListDaoImpl implements PlanListDao {
	private static final String namespace = "com.yi.mapper.PlanListMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertPlanList(PlanList planList) {
		// TODO Auto-generated method stub
		sqlSession.selectOne(namespace + ".insertPlanList", planList);
	}

	@Override
	public List<PlanList> selectByPno(int pno) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".selectByPno", pno);
	}

}
