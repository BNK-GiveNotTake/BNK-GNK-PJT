package com.service.gnt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.card.Card;
import com.service.gnt.model.dao.CardDAO;

@Service
public class CardServiceImpl implements CardService{
	
	@Autowired
	private CardDAO cardDAO;

	// 카드 생성 (유저 아이디 -- 카드 정보)
	@Override
	public void insertCard(Card card, String userId) throws Exception {	
		
		Account account = new Account();
		
		cardDAO.insertCard(card); // 카드 생성
		
		String accId = cardDAO.selectCardAccId(Integer.parseInt(userId)); // 고객의 계좌번호
		
		account.setAccId(accId); // 계좌번호
		account.setCardId(card.getCardId()); // 카드번호
		
		cardDAO.updateCardToAcc(account); // 계좌에 카드 번호 추가
	
	}

	
	// 카드 삭제 :: 신규 발급자가 아닌 경우, 카드 생성 전 실행 -- card만 삭제하네.. 어차피 추가하니까?
	@Override
	public void deleteCard(String userId) throws Exception {
		String accId = cardDAO.selectCardAccId(Integer.parseInt(userId));
		String cardId = cardDAO.selectCardId(accId);
		cardDAO.deleteCard(cardId); // card 정보를 삭제
		
		Account account = new Account();
		account.setAccId(accId);
		account.setCardId(null);
		
		cardDAO.updateCardToAcc(account); // user_id 에서 연결된 account의 card_id null로 변경
		
	}
	
	
	// 카드 번호 생성 :: 카드 번호가 존재하는 번호인지 확인
	@Override
	public boolean isExistCardId(String cardId) throws Exception {
		List<String> list = cardDAO.selectAccIds(); // 모든 고객의 계좌번호
		for (String accId : list) {
			if (cardId.equals(cardDAO.selectCardId(accId))) // 각 계좌번호의 카드번호와 현재 카드번호가 같으면
				return true; // 있으면 true
		}
		return false;
	}

	// 카드 생성 시 :: 이전에 값이 있을 때
	@Override
	public boolean isReIssued(String userId) throws Exception {
		String accId = cardDAO.selectCardAccId(Integer.parseInt(userId));
		String cardId = cardDAO.selectCardId(accId);
		if (cardId != null && cardId.length() != 0) // null이 아니거나 길이가 0이 아닐 때 - 값이 있을 때
			return true;
		return false;
	}


	
	
	
	// new
	// new
	// new
	
	
	
	
	
	// 현재 저장되어 있는 값이 발급 받았다면 true, 발급 안 받았다면(저장만 되어 있다면) false
	@Override
	public boolean selectIsIssued(String userId) throws Exception {
		String accId = cardDAO.selectCardAccId(Integer.parseInt(userId));
		String cardId = cardDAO.selectCardId(accId);
		String isIssued = cardDAO.selectIsIssued(cardId);
		System.out.println("cardId? + "+cardId);
		System.out.println("isissued? + "+isIssued);
		if (isIssued!=null && isIssued.equals("1")) {
			return true;
		}
		
		return false;
	}


	// 발급은 받았는데, 받은 상태에서 갱신 날짜가 지나지 않았으면 true, 날짜가 변했으면 false
	@Override
	public String selectEndtime(String userId) throws Exception {
		String accId = cardDAO.selectCardAccId(Integer.parseInt(userId));
		String cardId = cardDAO.selectCardId(accId);
		String endTime = cardDAO.selectEndtime(cardId);
		
		endTime.substring(0, 9); // 2022-09-02
		
		return endTime;
		
	}


	// 기존의 카드 정보를 가져온다
	@Override
	public Card selectCard(String userId) throws Exception {
		String accId = cardDAO.selectCardAccId(Integer.parseInt(userId));
		String cardId = cardDAO.selectCardId(accId);
		Card card = cardDAO.selectCard(cardId);
		return card;
	}


	// 기존의 카드 내역을 변경한다
	@Override
	public void updateCard(String userId, Card card) throws Exception {
		String accId = cardDAO.selectCardAccId(Integer.parseInt(userId));
		String cardId = cardDAO.selectCardId(accId);
		card.setCardId(cardId);
		cardDAO.updateCard(card);
	}


	// 발급 버튼을 눌렀을 때
	@Override
	public void updateCardIssued(String userId) throws Exception {
		String accId = cardDAO.selectCardAccId(Integer.parseInt(userId));
		String cardId = cardDAO.selectCardId(accId);
		cardDAO.updateCardIssued(cardId);
	}


}
