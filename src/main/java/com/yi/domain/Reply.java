package com.yi.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Reply {
	private int rno;
	private String content;
	private String writer;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date moddate;

	public Reply() {}

	public Reply(int rno, String content, String writer, Date regdate, Date moddate) {
		this.rno = rno;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.moddate = moddate;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	@Override
	public String toString() {
		return String.format("Reply [rno=%s, content=%s, writer=%s, regdate=%s, moddate=%s]", rno, content, writer,
				regdate, moddate);
	}

}
