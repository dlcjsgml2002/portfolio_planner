package com.yi.domain;

public class Login {
	private int mno;
	private String id;
	private String name;
	private boolean admin;

	public Login() {}

	public Login(int mno, String id, String name, boolean admin) {
		this.mno = mno;
		this.id = id;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return String.format("Login [mno=%s, id=%s, name=%s, admin=%s]", mno, id, name, admin);
	}

}
