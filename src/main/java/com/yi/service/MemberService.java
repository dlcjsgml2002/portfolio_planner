package com.yi.service;

import java.util.List;

import com.yi.domain.Member;

public interface MemberService {
	public boolean insert(Member member);

	public Member read(String id, String pw);

	public void update(Member member);

	public void delete(Member member);

	public List<Member> selectByAll();
	
	public Member selectById(Member member);
	
	public Member selectByMno(int mno);

}
