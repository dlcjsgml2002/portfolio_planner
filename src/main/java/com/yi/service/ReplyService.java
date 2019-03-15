package com.yi.service;

import java.util.List;

import com.yi.domain.Criteria;
import com.yi.domain.Reply;

public interface ReplyService {
	public List<Reply> list(int bno);

	public void create(Reply reply);

	public void update(Reply reply);

	public void delete(int rno);

	public List<Reply> listpage(Criteria cri, int bno);

	public int totalCount(int bno);

	public Reply selectByRno(int rno);
}
