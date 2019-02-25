package com.yi.domain;

import java.util.Date;

public class Plan {
	private int pno;
	private String title;
	private int set;
	private Date startDate;
	private Date endDate;
	private Member member;
	private Exercise exercise;

	public Plan() {}

	public Plan(int pno, String title, int set, Date startDate, Date endDate, Member member, Exercise exercise) {
		this.pno = pno;
		this.title = title;
		this.set = set;
		this.startDate = startDate;
		this.endDate = endDate;
		this.member = member;
		this.exercise = exercise;
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

	public int getSet() {
		return set;
	}

	public void setSet(int set) {
		this.set = set;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	@Override
	public String toString() {
		return String.format("Plan [pno=%s, title=%s, set=%s, startDate=%s, endDate=%s, member=%s, exercise=%s]", pno,
				title, set, startDate, endDate, member, exercise);
	}

}
