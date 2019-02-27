package com.yi.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.Criteria;
import com.yi.domain.Reply;

@Repository
public class ReplyDaoImpl implements ReplyDao {
	private static final String namespace = "com.yi.mapper.ReplyMapper";

	@Autowired
	private SqlSession session;

	@Override
	public List<Reply> list(int bno) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".list", bno);
	}

	@Override
	public void create(Reply reply) {
		// TODO Auto-generated method stub
		session.insert(namespace + ".create", reply);
	}

	@Override
	public void update(Reply reply) {
		// TODO Auto-generated method stub
		session.update(namespace + ".update", reply);
	}

	@Override
	public void delete(int rno) {
		// TODO Auto-generated method stub
		session.delete(namespace + ".delete", rno);
	}

	@Override
	public List<Reply> listpage(Criteria cri, int bno) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("cri", cri);

		return session.selectList(namespace + ".listPage", map);
	}

	@Override
	public int totalCount(int bno) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".totalCount", bno);
	}

	@Override
	public Reply selectByRno(int rno) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".selectByRno", rno);
	}

}
