package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.yi.domain.Board;
import com.yi.domain.Criteria;
import com.yi.domain.SearchCriteria;
import com.yi.persistence.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao dao;

	@Override
	public void regist(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public Board read(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyFile(Board board, String[] delFiles, List<String> addImages) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int bno) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Board> listAll() {
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
	public void addAttach(String fullname) {
		// TODO Auto-generated method stub

	}

}
