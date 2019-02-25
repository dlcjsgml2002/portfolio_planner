package com.yi.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.Board;
import com.yi.domain.Criteria;
import com.yi.domain.SearchCriteria;

@Repository
public class BoardDaoImpl implements BoardDao {
	private static final String namespace = "com.yi.mapper.BoardMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(Board board) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insert", board);
	}

	@Override
	public Board read(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".read", bno);
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".update", board);
	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delete", bno);
	}

	@Override
	public List<Board> listAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listAll");
	}

	@Override
	public List<Board> listPage(int page) {
		// TODO Auto-generated method stub
		if (page < 0) {
			page = 1;
		}
		page = (page - 1) * 10;

		return sqlSession.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<Board> listCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".totalCount");
	}

	@Override
	public List<Board> listSearch(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int searchTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".searchTotalCount", cri);
	}

	@Override
	public void updateReplyCnt(int bno, int amount) {
		Map<String, Object> map = new HashMap<>();
		map.put("bno", bno);
		map.put("amount", amount);

		sqlSession.update(namespace + ".updateReplyCnt", map);
	}

	@Override
	public void addAttach(String fullname) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".addAttach", fullname);
	}

	@Override
	public List<String> getAttach(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".getAttach", bno);
	}

	@Override
	public void delAttach(int bno) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delAttach", bno);
	}

	@Override
	public void delAttachByFullName(int bno, String file) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("bno", bno);
		map.put("file", file);
		sqlSession.delete(namespace + ".delAttachByFullName", map);
	}

	@Override
	public void addAttachByBno(String file, int bno) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("file", file);
		map.put("bno", bno);
		sqlSession.insert(namespace + ".addAttachByBno", map);
	}

}
