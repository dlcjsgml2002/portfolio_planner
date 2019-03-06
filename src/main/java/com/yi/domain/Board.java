package com.yi.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Board {
	private int bno;
	private String title;
	private String content;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date moddate;
	private int viewcnt;
	private int replycnt;
	private Member member;
	private List<String> files;

	public Board() {}

	public Board(int bno, String title, String content, Date regdate, Date moddate, int viewcnt, int replycnt,
			Member member, List<String> files) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.moddate = moddate;
		this.viewcnt = viewcnt;
		this.replycnt = replycnt;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getModdate() {
		return moddate;
	}

	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public int getReplycnt() {
		return replycnt;
	}

	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
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
				"Board [bno=%s, title=%s, content=%s, regdate=%s, moddate=%s, viewcnt=%s, replycnt=%s, member=%s, files=%s]",
				bno, title, content, regdate, moddate, viewcnt, replycnt, member, files);
	}

}
