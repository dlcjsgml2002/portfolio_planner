package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.Exercise;

@Repository
public class ExerciseDaoImpl implements ExerciseDao {
	private static final String namespace = "com.yi.mapper.ExerciseMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(Exercise exercise) {
		sqlSession.insert(namespace + ".insert", exercise);
	}

	@Override
	public void update(Exercise exercise) {
		sqlSession.update(namespace + ".update", exercise);
	}

	@Override
	public void delete(int eno) {
		sqlSession.delete(namespace + ".delete", eno);
	}

	@Override
	public Exercise selectByEno(int eno) {
		return sqlSession.selectOne(namespace + ".selectByEno", eno);
	}

	@Override
	public List<Exercise> selectByAll() {
		return sqlSession.selectList(namespace + ".selectByAll");
	}

	@Override
	public List<Exercise> selectByPart(String part) {
		return sqlSession.selectList(namespace + ".selectByPart", part);
	}

	@Override
	public List<String> selectPartByPart() {
		return sqlSession.selectList(namespace + ".selectPartByPart");
	}

}
