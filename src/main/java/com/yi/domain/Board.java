package com.yi.domain;

import java.util.Date;
import java.util.List;

public class Board {
	private int bno;
	private String title;
	private String content;
	private Date regDate;
	private Date modDate;
	private int views;
	private Member member;
	private List<String> files;

	public Board() {}

	public Board(int bno, String title, String content, Date regDate, Date modDate, int views, Member member,
			List<String> files) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.modDate = modDate;
		this.views = views;
		this.member = member;
		this.files = files;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<String> getFiles() {
		return files;
	}

	public void setFiles(List<String> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return String.format(
				"Board [bno=%s, title=%s, content=%s, regDate=%s, modDate=%s, views=%s, member=%s, files=%s]", bno,
				title, content, regDate, modDate, views, member, files);
	}

}
