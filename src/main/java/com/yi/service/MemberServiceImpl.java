package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.Member;
import com.yi.persistence.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao dao;

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return dao.getTime();
	}

	@Override
	public void insertMember(Member member) {
		// TODO Auto-generated method stub
		dao.insertMember(member);
	}

	@Override
	public Member readmember(String id, String pw) {
		// TODO Auto-generated method stub
		return dao.readmember(id, pw);
	}

	@Override
	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public void updateMember(Member member) {
		// TODO Auto-generated method stub
		dao.updateMember(member);
	}

	@Override
	public void deleteMember(Member member) {
		// TODO Auto-generated method stub
		dao.deleteMember(member);
	}

}
