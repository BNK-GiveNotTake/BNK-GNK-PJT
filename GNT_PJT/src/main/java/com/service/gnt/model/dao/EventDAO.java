package com.service.gnt.model.dao;

import java.util.List;

import com.service.gnt.domain.event.Quiz;

public interface EventDAO {
	
	String selectQuizCK(String userId) throws Exception;
	String selectQuizId(String userId) throws Exception;
	Quiz selectQuiz(String quizId) throws Exception;
	
	int selectQuizAnswer(String quizId) throws Exception;
	int updateQuizUser(String userId) throws Exception;
	
	int updateQuizReset() throws Exception;
	List<Integer> selectAllUserId() throws Exception;

}