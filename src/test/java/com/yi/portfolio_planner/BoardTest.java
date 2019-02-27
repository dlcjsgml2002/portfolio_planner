package com.yi.portfolio_planner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yi.domain.Board;
import com.yi.domain.Criteria;
import com.yi.persistence.BoardDao;
import com.yi.persistence.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class BoardTest {

	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private MemberDao memberDao;

	@Test
	public void test01Insert() {
		Board board = new Board();
		board.setTitle("title");
		board.setContent("content");
		board.setMember(memberDao.read("user01", "passward"));
		
		boardDao.insert(board);
		System.out.println("insert : " + board);
	}

	@Test
	public void test02Read() {
		System.out.println("read : " + boardDao.read(1));
	}

	@Test
	public void test03Update() {
		Board board = new Board();
		board.setBno(3);
		board.setTitle("title2");
		board.setContent("content2");
		boardDao.update(board);
		System.out.println(board);
	}

	@Test
	public void testDelete() {
		boardDao.delete(4);
	}

	@Test
	public void testlistAll() {
		System.out.println(boardDao.listAll());
	}

	@Test
	public void testListPage() {
		int page = 3;
		boardDao.listPage(page);
	}

	@Test
	public void testListCriteria() {
		Criteria cri = new Criteria();
		cri.setPage(1);
		cri.setPerPageNum(20);
		boardDao.listCriteria(cri);
	}

	@Test
	public void testTotalCount() {
		System.out.println(boardDao.totalCount());
	}

}
