package com.service.gnt.model.service;

import java.util.List;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.card.Card;

public interface CardService {
	
	void insertCard(Card card, String userId) throws Exception;
	
	void deleteCard(String userId) throws Exception;
	
	boolean isExistCardId(String cardId) throws Exception;
	
	boolean isReIssued(String userId) throws Exception;
	
	
	
	
	// new
	boolean selectIsIssued(String userId) throws Exception;
	
	String selectEndtime(String userId) throws Exception;
	
	Card selectCard(String userId) throws Exception;
	
	void updateCard(String userId, Card card) throws Exception;
	
	void updateCardIssued(String userId) throws Exception;
	
	
	
	
	

}
