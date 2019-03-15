package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.Criteria;
import com.yi.domain.Reply;
import com.yi.persistence.BoardDao;
import com.yi.persistence.ReplyDao;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDao replyDao;

	@Autowired
	private BoardDao boardDao;

	@Override
	public List<Reply> list(int bno) {
		// TODO Auto-generated method stub
		return replyDao.list(bno);
	}

	@Override
	public void create(Reply reply) {
		// TODO Auto-generated method stub
		replyDao.create(reply);
		/*boardDao.updateReplyCnt(reply.getBoard().getBno(), 1);*/
	}

	@Override
	public void update(Reply vo) {
		// TODO Auto-generated method stub
		replyDao.update(vo);
	}

	@Override
	public void delete(int rno) {
		// TODO Auto-generated method stub
		// rno를 이용하여 bno값을 알아옴
		Reply reply = replyDao.selectByRno(rno);
		boardDao.updateReplyCnt(reply.getBoard().getBno(), -1);

		replyDao.delete(rno);
	}

	@Override
	public List<Reply> listpage(Criteria cri, int bno) {
		// TODO Auto-generated method stub
		return replyDao.listpage(cri, bno);
	}

	@Override
	public int totalCount(int bno) {
		// TODO Auto-generated method stub
		return replyDao.totalCount(bno);
	}

	@Override
	public Reply selectByRno(int rno) {
		// TODO Auto-generated method stub
		return null;
	}

}
