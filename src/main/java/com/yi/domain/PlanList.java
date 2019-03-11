package com.yi.domain;

public class PlanList {
	private int execnt;
	private int setcnt;
	private Plan plan;
	private Exercise exercise;

	public PlanList() {}

	public PlanList(int execnt, int setcnt, Plan plan, Exercise exercise) {
		this.execnt = execnt;
		this.setcnt = setcnt;
		this.plan = plan;
		this.exercise = exercise;
	}

	public int getExecnt() {
		return execnt;
	}

	public void setExecnt(int execnt) {
		this.execnt = execnt;
	}

	public int getSetcnt() {
		return setcnt;
	}

	public void setSetcnt(int setcnt) {
		this.setcnt = setcnt;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	@Override
	public String toString() {
		return String.format("PlanList [execnt=%s, setcnt=%s, plan=%s, exercise=%s]", execnt, setcnt, plan, exercise);
	}

}
