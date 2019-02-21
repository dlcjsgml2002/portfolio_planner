package com.yi.persistence;

import java.util.List;

import com.yi.domain.Board;
import com.yi.domain.Criteria;
import com.yi.domain.SearchCriteria;

public interface BoardDao {
	public void insert(Board board);

	public Board read(int bno);

	public void update(Board board);

	public void delete(int bno);

	public List<Board> listAll();

	public List<Board> listPage(int page);

	public List<Board> listCriteria(Criteria cri);

	public int totalCount();

	public List<Board> listSearch(SearchCriteria cri);

	public int searchTotalCount(SearchCriteria cri);

	public void updateReplyCnt(int bno, int amount);

	public void addAttach(String fullname);

	public List<String> getAttach(int bno);
	
	public void delAttach(int bno);
	
	public void delAttachByFullName(int bno, String fullname);
	
	public void addAttachByBno(String fullname, int bno);
}
