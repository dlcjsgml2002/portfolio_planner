package com.yi.domain;

import java.util.Date;

public class Plan {
	private int pno;
	private String title;
	private int setcnt;
	private Date startdate;
	private Date enddate;
	private boolean exec;
	private Member member;

	public Plan() {}

	public Plan(int pno, String title, int setcnt, Date startdate, Date enddate, boolean exec, Member member) {
		this.pno = pno;
		this.title = title;
		this.setcnt = setcnt;
		this.startdate = startdate;
		this.enddate = enddate;
		this.exec = exec;
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

	public int getSetcnt() {
		return setcnt;
	}

	public void setSetcnt(int setcnt) {
		this.setcnt = setcnt;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public boolean isExec() {
		return exec;
	}

	public void setExec(boolean exec) {
		this.exec = exec;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return String.format("Plan [pno=%s, title=%s, setcnt=%s, startdate=%s, enddate=%s, exec=%s, member=%s]", pno,
				title, setcnt, startdate, enddate, exec, member);
	}

}
