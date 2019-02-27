package com.yi.portfolio_planner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yi.domain.Member;
import com.yi.persistence.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MemberTest {

	@Autowired
	private MemberDao dao;
	
	@Test
	public void test01Insert() {
		Member member = new Member();
		member.setId("id");
		member.setPw("pw");
		member.setName("name");
		member.setEmail("email@test.com");
		member.setAdmin(true);
		System.out.println("insert : " + member);
		dao.insert(member);
	}

	@Test
	public void test02Read() {
		Member member = dao.read("id", "pw");
		System.out.println("read : " + member);
	}

	@Test
	public void test03Update() {
		Member member = new Member();
		member.setId("id2");
		member.setPw("pw2");
		member.setName("name2");
		member.setEmail("email2@test.com");
		dao.update(member);
		System.out.println("update" + member);
	}

	@Test
	public void test04Delete() {
		Member member = dao.read("id2", "pw2");
		System.out.println("delete : " + member);
		dao.delete(member);
	}

	@Test
	public void test05SelectAll() {
		System.out.println(dao.selectByAll());
	}

}
