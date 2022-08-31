package com.service.gnt.model.dao;

import java.util.List;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.card.Card;

public interface CardDAO {
	
	int insertCard(Card card) throws Exception;
	String selectAccId(String userId) throws Exception;
	int updateCardToAcc(Account account) throws Exception;
	int deleteCard(String userId) throws Exception;
	
	List<String> selectAccIds() throws Exception;
	String selectCardId(String accId) throws Exception;
	
	int updateCardIssued(String cardId) throws Exception;
	String selectCardDelete(String accId) throws Exception;

}
