package com.yi.domain;

import java.util.Date;

public class Board {
	private int bno;
	private String title;
	private String comment;
	private Member member;
	private Date regDate;
	private int views;

	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board(int bno, String title, String comment, Member member, Date regDate, int views) {
		super();
		this.bno = bno;
		this.title = title;
		this.comment = comment;
		this.member = member;
		this.regDate = regDate;
		this.views = views;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return String.format("Board [bno=%s, title=%s, comment=%s, member=%s, regDate=%s, views=%s]", bno, title,
				comment, member, regDate, views);
	}

}
