package com.yi.domain;

public class Plan {
	private int pno;
	private Exercise exercise;
	private String title;
	private int set;

	public Plan() {}

	public Plan(int pno, Exercise exercise, String title, int set) {
		this.pno = pno;
		this.exercise = exercise;
		this.title = title;
		this.set = set;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSet() {
		return set;
	}

	public void setSet(int set) {
		this.set = set;
	}

	@Override
	public String toString() {
		return String.format("Plan [pno=%s, exercise=%s, title=%s, set=%s]", pno, exercise, title, set);
	}
}
