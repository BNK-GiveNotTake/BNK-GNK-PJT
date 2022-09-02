package com.service.gnt.model.service;

import java.util.List;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.card.Card;

public interface CardService {
	
	void insertCard(Card card, int userId) throws Exception;
	
	void deleteCard(int userId) throws Exception;
	
	boolean isExistCardId(String cardId) throws Exception;
	
	boolean isReIssued(int userId) throws Exception;
	
	
	
	
	// new
	boolean selectIsIssued(int userId) throws Exception;
	
	String selectEndtime(int userId) throws Exception;
	
	Card selectCard(int userId) throws Exception;
	
	void updateCard(int userId, Card card) throws Exception;
	
	void updateCardIssued(int userId) throws Exception;
	
	
	
	
	

}
