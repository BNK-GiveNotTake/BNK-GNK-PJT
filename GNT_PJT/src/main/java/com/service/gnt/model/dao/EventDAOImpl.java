package com.service.gnt.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.account.MileageHistory;
import com.service.gnt.domain.event.Quiz;

@Repository
public class EventDAOImpl implements EventDAO{

	@Autowired
	private SqlSession sqlSession;
	private static final String NS = "ns.sql.EventMapper.";

	public String checkQuizPlayed(String userId) throws Exception {
		return sqlSession.selectOne(NS+"selectQuizCK",userId);
	}

	public String selectQuizId(String userId) throws Exception {
		return sqlSession.selectOne(NS+"selectQuizId",userId);
	}

	public Quiz getQuiz(String quizId) throws Exception {
		Quiz quiz = sqlSession.selectOne(NS+"selectQuiz",quizId);
		return quiz;
	}

	public int getQuizAnswer(String quizId) throws Exception {
		return sqlSession.selectOne(NS+"selectQuizAnswer",quizId);
	}

	public int updateQuizUser(String userId) throws Exception {
		return sqlSession.update(NS+"updateQuizUser",userId);
	}
	
	public String selectQuizAccId(String userId) throws Exception {
		return sqlSession.selectOne(NS+"selectQuizAccId",userId);
	}

	public int updateQuizMileage(Account account) throws Exception {
		return sqlSession.update(NS+"updateQuizMileage",account);
	}

	public int selectMilieageHistorySeq() throws Exception {
		return sqlSession.selectOne(NS+"selectMilieageHistorySeq");
	}

	public int insertMilieage(MileageHistory mh) throws Exception {
		return sqlSession.insert(NS+"insertMilieage",mh);
	}

	public int updateQuizReset() throws Exception {
		return sqlSession.update(NS+"updateQuizReset");
	}

	public List<Integer> selectAllUserId() throws Exception {
		List<Integer> list = sqlSession.selectList(NS+"selectAllUserId");
		return list;
	}



}
