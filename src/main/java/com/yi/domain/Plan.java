package com.yi.domain;

import java.util.List;

public class Plan {
	private int pno;
	private String title;
	private Member member;
	private List<PlanList> planList;
	private List<PlanDate> planDate;

	public Plan() {
	}

	public Plan(int pno, String title, Member member) {
		this.pno = pno;
		this.title = title;
		this.member = member;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<PlanList> getPlanList() {
		return planList;
	}

	public void setPlanList(List<PlanList> planList) {
		this.planList = planList;
	}

	public List<PlanDate> getPlanDate() {
		return planDate;
	}

	public void setPlanDate(List<PlanDate> planDate) {
		this.planDate = planDate;
	}

	@Override
	public String toString() {
		return String.format("Plan [pno=%s, title=%s, member=%s, planList=%s, planDate=%s]", pno, title, member,
				planList, planDate);
	}

}
