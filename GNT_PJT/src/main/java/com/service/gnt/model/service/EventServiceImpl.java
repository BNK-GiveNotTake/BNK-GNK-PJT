package com.service.gnt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.account.MileageHistory;
import com.service.gnt.domain.event.Quiz;
import com.service.gnt.model.dao.EventDAO;

@Service
public class EventServiceImpl implements EventService{
	
	@Autowired
	private EventDAO eventDAO;

	
	// 퀴즈 풀이 여부 확인하기 (0->안 풀었음,  1-> 풀었음)
	@Override
	public String selectQuizCK(String userId) throws Exception {
		return eventDAO.selectQuizCK(userId);
	}
	
	// 퀴즈 조회
	@Override
	public Quiz selectQuiz(String userId) throws Exception {
		String quizId = eventDAO.selectQuizId(userId); // 고객 퀴즈번호
		Quiz quiz = eventDAO.selectQuiz(quizId); // 퀴즈
		return quiz;
	}

	// 퀴즈 제출 이후
	@Override
	public int selectQuizAnswer(String userId) throws Exception {
		String quizId = eventDAO.selectQuizId(userId); // 고객 퀴즈번호
		int result = eventDAO.selectQuizAnswer(quizId); // 퀴즈 정답
		
		eventDAO.updateQuizUser(userId); // 퀴즈 풀이 이후 고객 DB 값 변경
		
		return result; // 퀴즈 정답
	}
	
	// 정답을 맞췄을 시
	@Override
	public void eventQuizWinner(String userId, int random) throws Exception {
		String accId = eventDAO.selectQuizAccId(userId); // 계좌 번호
		
		Account account = new Account(); // 계좌 VO에 계좌번호, 마일리지 금액 생성
		account.setAccId(accId);
		account.setMileage(random);
		
		eventDAO.updateQuizMileage(account); // 계좌 속 마일리지 변경
		
		int mhSeq = eventDAO.selectMilieageHistorySeq(); // 마일리지 내역 seq
		
		MileageHistory mh = new MileageHistory(); // 마일리지 내역 VO에 값 할당 
		mh.setMileagePk(mhSeq);
		mh.setAccId(accId);
		mh.setMileageAmount(random);
		mh.setMileageContent("적립");
		
		eventDAO.insertMilieage(mh); // 마일리지 내역 생성
	}
	
	
	// 퀴즈 리셋
	@Override
	public void eventResetToQuiz() throws Exception {
		eventDAO.updateQuizReset();
	}

	// 돌림판 참가자 반환
	@Override
	public List<Integer> eventResetToRoulette() throws Exception {
		List<Integer> list = eventDAO.selectAllUserId();
		return list;
	}

	
	
	

}
