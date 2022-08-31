package com.service.gnt.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.gnt.domain.notice.Notice;


@Repository
public class NoticeDAOImpl implements NoticeDAO{
	private static final String NM = "ns.sql.NoticeMapper.";
	@Autowired
	private SqlSession sqlSession;
	
	public List<Notice> getNoticeList(){
		return sqlSession.selectList(NM+"getNoticeList");
	}
	public int getNoticeAMT() {
		return sqlSession.selectOne(NM+"getNoticeAMT");
	}
	public Notice getNoticeDetail(int noticeId) {
		sqlSession.update(NM+"addNoticeCNT", noticeId);
		return sqlSession.selectOne(NM+"getNoticeDetail", noticeId);
	}
	
	@Override
	public int addNoticeCNT(int noticeId) {
		return sqlSession.update(NM+"addNoticeCNT", noticeId);
	}
}
