package com.service.gnt.model.service;

import java.util.List;

import com.service.gnt.domain.event.Quiz;

public interface EventService {
	// 퀴즈 풀이 여부
	String checkQuizPlayed(String userId) throws Exception;
	// 퀴즈 데이터 가져오기
	Quiz getQuiz(String userId) throws Exception;
	// 퀴즈 정답 반환 및 고객 퀴즈 데이터 변경
	int getQuizAnswer(String userId) throws Exception;
	// 고객이 정답을 맞췄을 시
	void expressQuizWin(String userId, int random) throws Exception;
	// 퀴즈와 룰렛 세팅
	void resetQuiz() throws Exception;
	List<Integer> resetRoullete() throws Exception;
	

}
