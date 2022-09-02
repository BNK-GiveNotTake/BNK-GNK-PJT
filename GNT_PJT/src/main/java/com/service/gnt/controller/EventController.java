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
			result.put("message", "no"); // 이미 풀었어
		}
		else {
			result.put("message", "yes"); // 안 풀었어
		}
		
		return result;
	}
	
	@GetMapping("getQuiz.do")
	public Map<String, Object> getQuiz (String userId) throws Exception {
	
		Map<String, Object> result = new HashMap<String, Object>();
		Quiz quiz;
		
									
		try {
			quiz = eventService.selectQuiz(userId);
			result.put("notices", quiz);
			result.put("message", "yes"); // 이거 왜 넣는거지
		}
		catch (Exception e) {
			result.put("message", "no");
		}
										   
										   
		
		return result;
	
	}
	
	@GetMapping("submitAnswer.do")
	public Map<String, Object> submitAnswer (String userId, String userAnswer) throws Exception {
	
		Map<String, Object> result = new HashMap<String, Object>();
		
		int answer = eventService.selectQuizAnswer(userId);
		
		if (answer == Integer.parseInt(userAnswer)) {
			
			int cash = (int)(Math.random() * (500-10))+10; // 10원 ~ 500원으로 하자 매일이자나 
			eventService.eventQuizWinner(userId, cash);

			result.put("mileage", cash);
			result.put("message", "yes");
		}
		else {
			result.put("message", "no");
		}
		
		return result;
	
	}
	
	
	@GetMapping("getRouletteWinner.do")
	public Map<String, String> getRouletteWinner (String userId) throws Exception {
	
		Map<String, String> result = new HashMap<String, String>();
												
  
		int winner = (int)servletContext.getAttribute("winner");
		System.out.println("EventController :: "+winner);
		if (userId.equals(winner)) {
			// 어떻게 이벤트 상품 줄래!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			result.put("message", "yes");
		}
		else {
			result.put("message", "no");
		}
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
		
		servletContext.setAttribute("winner", winner); // error ----------------- 매일 값 바꿀 수 있는 건가?
		
	}
	
	
	
	
	

}
