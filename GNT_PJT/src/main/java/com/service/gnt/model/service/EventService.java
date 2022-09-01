package com.service.gnt.model.service;

import java.util.List;

import com.service.gnt.domain.event.Quiz;

public interface EventService {
	
	// 퀴즈 풀이 여부
	String selectQuizCK(String userId) throws Exception;
	
	// 퀴즈 데이터 가져오기
	Quiz selectQuiz(String userId) throws Exception;
	
	// 퀴즈 정답 반환 및 고객 퀴즈 데이터 변경
	int selectQuizAnswer(String userId) throws Exception;
	
	// 고객이 정답을 맞췄을 시
	void eventQuizWinner(String userId, int random) throws Exception;
	
	// 퀴즈와 룰렛 세팅
	void eventResetToQuiz() throws Exception;
	List<Integer> eventResetToRoulette() throws Exception;
	

}
