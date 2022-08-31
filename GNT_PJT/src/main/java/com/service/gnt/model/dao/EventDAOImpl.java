package com.service.gnt.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.gnt.domain.event.Quiz;

@Repository
public class EventDAOImpl implements EventDAO{

	@Autowired
	private SqlSession sqlSession;
	private static final String NS = "ns.sql.EventMapper.";

	@Override
	public String selectQuizCK(String userId) throws Exception {
		return sqlSession.selectOne(NS+"selectQuizCK",userId);
	}

	@Override
	public String selectQuizId(String userId) throws Exception {
		return sqlSession.selectOne(NS+"selectQuizId",userId);
	}

	@Override
	public Quiz selectQuiz(String quizId) throws Exception {
		Quiz quiz = sqlSession.selectOne(NS+"selectQuiz",quizId);
		return quiz;
	}

	@Override
	public int selectQuizAnswer(String quizId) throws Exception {
		return sqlSession.selectOne(NS+"selectQuizAnswer",quizId);
	}

	@Override
	public int updateQuizUser(String userId) throws Exception {
		return sqlSession.update(NS+"updateQuizUser",userId);
	}

	@Override
	public int updateQuizReset() throws Exception {
		return sqlSession.update(NS+"updateQuizReset");
	}

	@Override
	public List<Integer> selectAllUserId() throws Exception {
		List<Integer> list = sqlSession.selectList(NS+"selectAllUserId");
		return list;
	}

}
