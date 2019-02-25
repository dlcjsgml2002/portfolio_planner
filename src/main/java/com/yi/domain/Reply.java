package com.yi.domain;

import java.util.Date;

public class Reply {
	private int rno;
	private int bno;
	private String replytext;
	private String replyer;
	private Date regDate;
	private Date modDate;

	public Reply() {}

	public Reply(int rno, int bno, String replytext, String replyer, Date regDate, Date modDate) {
		this.rno = rno;
		this.bno = bno;
		this.replytext = replytext;
		this.replyer = replyer;
		this.regDate = regDate;
		this.modDate = modDate;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getReplytext() {
		return replytext;
	}

	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}

	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
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

	@Override
	public String toString() {
		return String.format("Reply [rno=%s, bno=%s, replytext=%s, replyer=%s, regDate=%s, modDate=%s]", rno, bno,
				replytext, replyer, regDate, modDate);
	}

}
