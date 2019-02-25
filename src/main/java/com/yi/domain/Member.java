package com.yi.domain;

public class Member {
	private int mno;
	private String id;
	private String pw;
	private String name;
	private String email;
	private boolean admin;

	public Member() {}

	public Member(int mno, String id, String pw, String name, String email, boolean admin) {
		this.mno = mno;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return String.format("Member [mno=%s, id=%s, pw=%s, name=%s, email=%s, admin=%s]", mno, id, pw, name, email,
				admin);
	}

}
