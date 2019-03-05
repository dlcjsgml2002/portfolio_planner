package com.yi.domain;

public class Plan {
	private int pno;
	private String title;
	private Member member;

	public Plan() {}

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

	@Override
	public String toString() {
		return String.format("Plan [pno=%s, title=%s, member=%s]", pno, title, member);
	}

}
