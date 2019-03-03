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
	public boolean insert(Member member) {
		
		Member check_member = dao.selectById(member);
		System.out.println("member : " + check_member);
		if (check_member == null) {
			dao.insert(member);
		}else {
			return false;
		}
		return true;
	}

	@Override
	public Member read(String id, String pw) {
		// TODO Auto-generated method stub
		return dao.read(id, pw);
	}

	@Override
	public void update(Member member) {
		// TODO Auto-generated method stub
		dao.update(member);
	}

	@Override
	public void delete(Member member) {
		// TODO Auto-generated method stub
		dao.delete(member);
	}

	@Override
	public List<Member> selectByAll() {
		// TODO Auto-generated method stub
		return dao.selectByAll();
	}

	@Override
	public Member selectById(Member member) {
		// TODO Auto-generated method stub
		return dao.selectById(member);
	}

}
