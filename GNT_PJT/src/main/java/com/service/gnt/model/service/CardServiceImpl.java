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

	
	// 카드 삭제 :: 신규 발급자가 아닌 경우, 카드 생성 전 실행
	@Override
	public void deleteCard(String userId) throws Exception {
		String accId = cardDAO.selectCardAccId(Integer.parseInt(userId));
		String cardId = cardDAO.selectCardDelete(accId);
		cardDAO.deleteCard(cardId);
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


	@Override
	public boolean isReIssued(String userId) throws Exception {
		String accId = cardDAO.selectCardAccId(Integer.parseInt(userId)); // 고객의 계좌번호
		String cardId = cardDAO.selectCardDelete(accId); // 고객의 카드번호
		if (cardId != null && cardId.length() != 0) // null이 아니거나 길이가 0이 아닐 때 - 값이 있을 때
			return true;
		return false;
	}


}
