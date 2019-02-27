package com.yi.domain;

import java.util.Date;

public class Information {
	private double weight;
	private double height;
	private Date regdate;
	private Member member;

	public Information() {}

	public Information(double weight, double height, Date regdate, Member member) {
		this.weight = weight;
		this.height = height;
		this.regdate = regdate;
		this.member = member;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return String.format("Information [weight=%s, height=%s, regdate=%s, member=%s]", weight, height, regdate,
				member);
	}

}
