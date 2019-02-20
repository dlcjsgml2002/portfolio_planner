package com.yi.domain;

import java.util.Date;

public class Calendar {
	private int cno;
	private Member member;
	private Plan plan;
	private String category;
	private String title;
	private String content;
	private Date date;

	public Calendar() {}

	public Calendar(int cno, Member member, Plan plan, String category, String title, String content, Date date) {
		this.cno = cno;
		this.member = member;
		this.plan = plan;
		this.category = category;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return String.format("Calendar [cno=%s, member=%s, plan=%s, category=%s, title=%s, content=%s, date=%s]", cno,
				member, plan, category, title, content, date);
	}

}
