package com.service.gnt.model.dao;
import java.util.List;
import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.account.MileageHistory;
import com.service.gnt.domain.event.Quiz;
public interface EventDAO {
	// 퀴즈 풀이 여부
	String checkQuizPlayed(int userId) throws Exception;
	// 퀴즈 데이터 가져오기
	int selectQuizId(int userId) throws Exception;
	Quiz getQuiz(int quizId) throws Exception;
	// 퀴즈 정답 반환 및 고객 퀴즈 데이터 변경
	int getQuizAnswer(int quizId) throws Exception;
	int updateQuizUser(int userId) throws Exception;
	// 고객이 정답을 맞췄을 시
	String selectQuizAccId(int userId) throws Exception;
	int updateQuizMileage(Account account) throws Exception;
	int selectMilieageHistorySeq() throws Exception;
	int insertMilieage(MileageHistory mh) throws Exception;
	// 퀴즈와 룰렛 세팅
	int updateEventReset() throws Exception;
	int updateRouletteUser(int userId) throws Exception;
	List<Integer> selectAllUserId() throws Exception;
}