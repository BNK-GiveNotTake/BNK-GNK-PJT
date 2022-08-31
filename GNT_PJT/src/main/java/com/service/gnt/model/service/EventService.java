package com.service.gnt.model.service;

import java.util.List;

import com.service.gnt.domain.event.Quiz;

public interface EventService {
	
	String selectQuizCK(String userId) throws Exception;
	
	Quiz selectQuiz(String userId) throws Exception;
	
	int selectQuizAnswer(String userId) throws Exception;
	
	void eventResetToQuiz() throws Exception;
	List<Integer> eventResetToRoulette() throws Exception;
	

}
