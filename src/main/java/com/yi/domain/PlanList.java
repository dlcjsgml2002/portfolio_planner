package com.yi.domain;

public class PlanList {
	private int setcnt;
	private boolean exec;
	private Plan plan;
	private Exercise exercise;

	public PlanList() {}

	public PlanList(int setcnt, boolean exec, Plan plan, Exercise exercise) {
		this.setcnt = setcnt;
		this.exec = exec;
		this.plan = plan;
		this.exercise = exercise;
	}

	public int getSetcnt() {
		return setcnt;
	}

	public void setSetcnt(int setcnt) {
		this.setcnt = setcnt;
	}

	public boolean isExec() {
		return exec;
	}

	public void setExec(boolean exec) {
		this.exec = exec;
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
		return String.format("List [setcnt=%s, exec=%s, plan=%s, exercise=%s]", setcnt, exec, plan, exercise);
	}

}
