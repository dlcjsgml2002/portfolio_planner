package com.yi.persistence;

import java.util.List;

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

	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Board> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> listPage(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> listCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Board> listSearch(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int searchTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateReplyCnt(int bno, int amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAttach(String fullname) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getAttach(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delAttach(int bno) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delAttachByFullName(int bno, String fullname) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAttachByBno(String fullname, int bno) {
		// TODO Auto-generated method stub

	}

}
