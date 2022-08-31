package com.service.gnt.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.gnt.domain.event.Quiz;
import com.service.gnt.model.service.EventService;

@Component
@RestController
public class EventController {
	
	@Autowired ServletContext servletContext;
	
	@Autowired
	private EventService eventService;

	@GetMapping("checkedQuiz.do")
	public Map<String, String> checkedQuiz (String userId) throws Exception {
		
		Map<String, String> result = new HashMap<String, String>();
		
		String check = eventService.selectQuizCK(userId);
		
		if (check.equals("1")) {
			result.put("check", "no");
		}
		else {
			result.put("check", "yes");
		}
		
		return result;
	}
	
	@GetMapping("getQuiz.do")
	public Map<String, String> getQuiz (String userId) throws Exception {
	
		Map<String, String> result = new HashMap<String, String>();
		
		Quiz quiz = eventService.selectQuiz(userId);
		
		// 물어보기. string으로 보내는 게 편한가 아니면 quiz 객체 자체로 보내는 게 편한가?
		result.put("content", quiz.getQuizContent());
		result.put("select1", quiz.getSelect1());
		result.put("select2", quiz.getSelect2());
		result.put("select3", quiz.getSelect3());
		result.put("select4", quiz.getSelect4());
		
		return result;
	
	}
	
	@GetMapping("submitAnswer.do")
	public Map<String, Integer> submitAnswer (String userId) throws Exception {
	
		Map<String, Integer> result = new HashMap<String, Integer>();
		
		int answer = eventService.selectQuizAnswer(userId);
		
		result.put("answer", answer);
		
		return result;
	
	}
	
	@GetMapping("getRouletteWinner.do")
	public Map<String, String> getRouletteWinner (String userId) throws Exception {
	
		Map<String, String> result = new HashMap<String, String>();
		
		int winUser = (int)servletContext.getAttribute("winUser");
		
		if (userId.equals(winUser))
			result.put("winner", "no");
		else
			result.put("winner", "yes");
		
		return result;
	
	}
	
	
	// 확인해봐야함. 여기 들어가도 돌아가려나? -- application 앞에 @EnableScheduling 붙여야 함 + class 앞에 @component 붙여야 함
	@Scheduled(cron = "0 0 0 * * *")
	public void doSchedule() throws Exception {
		
		// 퀴즈 리셋
		eventService.eventResetToQuiz();
		
		// 돌림판 추첨 -- user가 삭제될 수도 있으니, null이 아닐 때까지 계속 반복(삭제는 안 하는 걸로.)
		List<Integer> user = eventService.eventResetToRoulette();
		int winner = 0;
		
		Collections.shuffle(user);
		winner = user.get(0);
		
		servletContext.setAttribute("winUser", winner); // error ----------------- 매일 값 바꿀 수 있는 건가?
		
	}
	
	
	
	
	

}
