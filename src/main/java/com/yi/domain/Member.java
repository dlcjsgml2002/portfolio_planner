package com.yi.domain;

public class Member {
	private int mno;
	private String id;
	private String password;
	private String name;
	private String email;
	private boolean admin;
	private double height;
	private double weight;

	public Member() {}

	public Member(int mno, String id, String password, String name, String email, boolean admin, double height,
			double weight) {
		this.mno = mno;
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.admin = admin;
		this.height = height;
		this.weight = weight;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return String.format("Member [mno=%s, id=%s, password=%s, name=%s, email=%s, admin=%s, height=%s, weight=%s]",
				mno, id, password, name, email, admin, height, weight);
	}

}
