package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.Exercise;
import com.yi.persistence.ExerciseDao;

@Service
public class ExerciseServiceImpl implements ExerciseService {

	@Autowired
	private ExerciseDao exerciseDao;

	@Override
	public void insert(Exercise exercise) {
		exerciseDao.insert(exercise);
	}

	@Override
	public void update(Exercise exercise) {
		exerciseDao.update(exercise);
	}

	@Override
	public void delete(int eno) {
		exerciseDao.delete(eno);
	}

	@Override
	public Exercise selectByEno(int eno) {
		return exerciseDao.selectByEno(eno);
	}

	@Override
	public List<Exercise> selectByPart(String part) {
		return exerciseDao.selectByPart(part);
	}

	@Override
	public List<Exercise> selectByAll() {
		return exerciseDao.selectByAll();
	}

}
