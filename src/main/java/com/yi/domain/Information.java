package com.yi.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Information {
	private int age;
	private String gender;
	private double weight;
	private double height;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate;
	private Member member;

	public Information() {}

	public Information(int age, String gender, double weight, double height, Date regdate, Member member) {
		this.age = age;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
		this.regdate = regdate;
		this.member = member;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
		return String.format("Information [age=%s, gender=%s, weight=%s, height=%s, regdate=%s, member=%s]", age,
				gender, weight, height, regdate, member);
	}

}
