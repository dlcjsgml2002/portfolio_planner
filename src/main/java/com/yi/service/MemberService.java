package com.yi.service;

import java.util.List;

import com.yi.domain.Member;

public interface MemberService {
	public String getTime();

	public void insertMember(Member member);

	public Member readmember(String id, String pw);

	public List<Member> selectAll();

	public void updateMember(Member member);

	public void deleteMember(Member member);

}
