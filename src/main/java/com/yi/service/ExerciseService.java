package com.yi.service;

import java.util.List;

import com.yi.domain.Exercise;

public interface ExerciseService {
	public void insert(Exercise exercise);

	public void update(Exercise exercise);

	public void delete(int eno);

	public Exercise selectByEno(int eno);

	public List<Exercise> selectByPart(String part);

	public List<Exercise> selectByAll();

}
