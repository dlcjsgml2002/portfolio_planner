package com.yi.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PlanDate {
	private int pdno;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date appDate;
	private boolean execute;
	private Plan plan;

	public PlanDate() {}

	public PlanDate(int pdno, Date appDate, boolean execute, Plan plan) {
		this.pdno = pdno;
		this.appDate = appDate;
		this.execute = execute;
		this.plan = plan;
	}

	public int getPdno() {
		return pdno;
	}

	public void setPdno(int pdno) {
		this.pdno = pdno;
	}

	public Date getAppDate() {
		return appDate;
	}

	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}

	public boolean isExecute() {
		return execute;
	}

	public void setExecute(boolean execute) {
		this.execute = execute;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return String.format("PlanDate [pdno=%s, appDate=%s, execute=%s, plan=%s]", pdno, appDate, execute, plan);
	}

}
