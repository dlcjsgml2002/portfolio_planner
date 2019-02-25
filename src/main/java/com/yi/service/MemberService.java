package com.yi.service;

import java.util.List;

import com.yi.domain.Member;

public interface MemberService {
	public void insert(Member member);

	public Member read(String id, String pw);

	public void update(Member member);

	public void delete(Member member);

	public List<Member> selectAll();

}
