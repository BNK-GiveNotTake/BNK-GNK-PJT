package com.service.gnt.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.gnt.domain.notice.Notice;


@Repository
public class NoticeDAOImpl implements NoticeDAO{
	@Autowired
	private SqlSession sqlSession;
	public List<Notice> getNoticeList(){
		return sqlSession.selectList("ns.sql.NoticeMapper.getNoticeList");
	}
	public int getNoticeAMT() {
		return sqlSession.selectOne("ns.sql.NoticeMapper.getNoticeAMT");
	}
	public Notice getNoticeDetail(int noticeId) {
		return sqlSession.selectOne("ns.sql.NoticeMapper.getNoticeDetail", noticeId);
	}
}
