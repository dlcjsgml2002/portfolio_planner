package com.yi.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "com.yi.mapper.MemberMapper";

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getTime");
	}

	@Override
	public void insertMember(Member member) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertMember", member);
	}

	@Override
	public Member readmember(String id, String pw) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		return sqlSession.selectOne(namespace + ".readMember", map);
	}

	@Override
	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".selectAll");
	}

	@Override
	public void updateMember(Member member) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".updateMember", member);
	}

	@Override
	public void deleteMember(Member member) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".deleteMember", member);
	}

}
