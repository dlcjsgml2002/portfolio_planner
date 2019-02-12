package com.yi.domain;

public class Criteria {
	private int page; // 선택한 페이지 번호
	private int perPageNum; // 페이지 당 몇개 읽을 것인지 가지는 변수

	public Criteria() {
		page = 1;
		perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			page = 1;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			perPageNum = 10;
		}
		this.perPageNum = perPageNum;
	}

	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}

	@Override
	public String toString() {
		return String.format("Criteria [page=%s, perPageNum=%s]", page, perPageNum);
	}
}
