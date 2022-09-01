package com.service.gnt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.gnt.domain.card.Card;
import com.service.gnt.model.service.CardService;

@RestController
public class CardDesignController {

	@Autowired
	private CardService cardService;
	
	
	// 내일 재호오빠에게 -> 우리 한 곳으로 요청하고 저장인지 발급인지 데이터 넘겨주자
	@PostMapping("insertCard.do")
	public Map<String, String> createCard(String userId, String bg_front, String bg_back, String emoId, String emoInfoTop, String emoInfoLeft, String font, String cardContent) throws Exception {
		
		Map<String, String> result = new HashMap<String, String>();
		
		// 카드 번호 랜덤 생성 (4번 만들어서 4번 붙이자!)
		// 카드 랜덤 확인 (false 뜰 때까지 반복)
		String tempCard = "";
		while (tempCard=="" || cardService.isExistCardId(tempCard)) {  // -------------------------------------------------------------- error check
			tempCard = "";
			for (int i=0;i<4;i++) {
				int ranNum = (int)(Math.random() * (9999-1000))+1000;
				tempCard += Integer.toString(ranNum);
			}
			System.out.println("cardDesignController :: temp card id? -> "+tempCard);
		}
		
		// cvc 랜덤 생성 (중복 체크 안 해도 됨)
		int tempCvc = (int)(Math.random() * (999-100))+100;
		
		// 카드 객체 생성해서 담기
		Card card = new Card(tempCard, tempCvc, bg_front, bg_back, Integer.parseInt(emoId), Integer.parseInt(emoInfoTop), Integer.parseInt(emoInfoLeft), font, cardContent); // emo_id int값
		
		try {
			// 카드 재발급 유무 확인 + 카드 재발급이 맞다면 delete 호출
			if (cardService.isReIssued(userId))
				cardService.deleteCard(userId);
			
			// 카드 생성
			cardService.insertCard(card, userId);
			
			result.put("message", "yes");
		
		} catch (Exception e) {
			result.put("message", "no");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
}
