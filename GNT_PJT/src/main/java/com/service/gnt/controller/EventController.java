package com.service.gnt.controller;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.gnt.domain.event.Quiz;
import com.service.gnt.model.service.EventService;
@Component
@RestController
public class EventController implements CommandLineRunner{
	@Autowired ServletContext servletContext;
	@Autowired
	private EventService eventService;
	@GetMapping("checkedQuiz.do")
	public Map<String, String> checkedQuiz (int userId) throws Exception {
		Map<String, String> result = new HashMap<String, String>();
		String check = eventService.checkQuizPlayed(userId);
		if (check.equals("1")) {
			result.put("message", "no"); // 이미 풀었어
		}
		else {
			result.put("message", "yes"); // 안 풀었어
		}
		return result;
	}
	@GetMapping("getQuiz.do")
	public Map<String, Object> getQuiz (int userId) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		Quiz quiz;
									
		try {
			quiz = eventService.getQuiz(userId);
			result.put("notices", quiz);
			result.put("message", "yes"); // 이거 왜 넣는거지
		}
		catch (Exception e) {
			result.put("message", "no");
		}
		return result;
	}
	@GetMapping("submitAnswer.do")
	public Map<String, Object> submitAnswer (int userId, String userAnswer) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		int answer = eventService.getQuizAnswer(userId);
		if (answer == Integer.parseInt(userAnswer)) {
			int cash = (int)(Math.random() * (500-10))+10; // 10원 ~ 500원으로 하자 매일이자나 
			eventService.expressQuizWin(userId, cash);
			result.put("mileage", cash);
			result.put("message", "yes");
		}
		else {
			result.put("message", "no");
		}
		return result;
	}
	@GetMapping("checkedRoulette.do")
	public Map<String, String> checkedRoulette (int userId) throws Exception {
		Map<String, String> result = new HashMap<String, String>();
		String check = eventService.checkRoulettePlayed(userId);
		if (check.equals("1")) {
			result.put("message", "no"); // 이미 돌렸어
		}
		else {
			result.put("message", "yes"); // 안 돌렸어
		}
		return result;
	}
	@GetMapping("getRouletteWinner.do")
	public Map<String, String> getRouletteWinner (int userId) throws Exception {
		Map<String, String> result = new HashMap<String, String>();
												
  
		int winner = (int)servletContext.getAttribute("winner");
		System.out.println("EventController :: "+winner);
		eventService.expressRoulette(userId);
		if (userId == winner) {
			result.put("message", "yes");
		}
		else {
			result.put("message", "no");
		}
		return result;
	}
	// 0시 0분 리셋
	@Scheduled(cron = "0 0 0 * * *")
	public void doSchedule() throws Exception {
		// 퀴즈 리셋
		eventService.resetEvent();
		// 돌림판 추첨 -- user가 삭제될 수도 있으니, null이 아닐 때까지 계속 반복(삭제는 안 하는 걸로.)
		List<Integer> user = eventService.resetRoulette();
		int winner = 0;
		Collections.shuffle(user);
		winner = user.get(0);
		servletContext.setAttribute("winner", winner); // error ----------------- 매일 값 바꿀 수 있는 건가?
		//int result = (int)servletContext.getAttribute("winner");
		//System.out.println("scheduler :: "+result);
	}
	// 서버가 구동될 때 실행
	@Override
	public void run(String... args) throws Exception {
		
		eventService.resetEvent();
		List<Integer> user = eventService.resetRoulette();
		int winner = 0;
		Collections.shuffle(user);
		winner = user.get(0);
		servletContext.setAttribute("winner", winner);
		
	}
}

