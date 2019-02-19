package com.yi.service;

import java.util.List;

import com.yi.domain.Board;
import com.yi.domain.Criteria;
import com.yi.domain.SearchCriteria;

public interface BoardService {
	public void regist(Board vo);

	public Board read(int bno);

	public void modify(Board vo);
	
	public void modifyFile(Board vo, String[] delFiles, List<String> addImages);

	public void remove(int bno);

	public List<Board> listAll();

	public List<Board> listCriteria(Criteria cri);
	
	public int totalCount();
	
	public List<Board> listSearch(SearchCriteria cri);

	public int searchTotalCount(SearchCriteria cri);
	
	public void addAttach(String fullname);

}
