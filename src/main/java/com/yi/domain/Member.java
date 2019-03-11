package com.yi.domain;

import java.util.Date;

public class Member {
	private int mno;
	private String id;
	private String pw;
	private String name;
	private String email;
	private int age;
	private String gender;
	private double weight;
	private double height;
	private Date regdate;
	private boolean admin;

	public Member() {}

	public Member(int mno, String id, String pw, String name, String email, int age, String gender, double weight,
			double height, Date regdate, boolean admin) {
		this.mno = mno;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
		this.regdate = regdate;
		this.admin = admin;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return String.format(
				"Member [mno=%s, id=%s, pw=%s, name=%s, email=%s, age=%s, gender=%s, weight=%s, height=%s, regdate=%s, admin=%s]",
				mno, id, pw, name, email, age, gender, weight, height, regdate, admin);
	}

}
