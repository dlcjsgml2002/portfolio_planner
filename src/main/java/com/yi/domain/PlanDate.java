package com.yi.domain;

import java.util.Date;

public class PlanDate {
	private Date appDate;
	private boolean exec;
	private Plan plan;

	public PlanDate() {}

	public PlanDate(Date appDate, boolean exec, Plan plan) {
		this.appDate = appDate;
		this.exec = exec;
		this.plan = plan;
	}

	public Date getAppDate() {
		return appDate;
	}

	public void setAppDate(Date appDate) {
		this.appDate = appDate;
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

	@Override
	public String toString() {
		return String.format("PlanDate [appDate=%s, exec=%s, plan=%s]", appDate, exec, plan);
	}

}
