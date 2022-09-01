package com.service.gnt.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.card.Card;

@Repository
public class CardDAOImpl implements CardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	public final static String NS = "ns.sql.CardMapper.";

	@Override
	public int insertCard(Card card) throws Exception {
		return sqlSession.insert(NS+"insertCard",card);
	}

	@Override
	public String selectCardAccId(int userId) throws Exception {
		return sqlSession.selectOne(NS+"selectCardAccId", userId);
	}

	@Override
	public int updateCardToAcc(Account account) throws Exception {
		return sqlSession.update(NS+"updateCardToAcc", account);
	}

	@Override
	public int deleteCard(String cardId) throws Exception {
		return sqlSession.delete(NS+"deleteCard", cardId);
	}

	@Override
	public List<String> selectAccIds() throws Exception {
		List<String> list = sqlSession.selectList(NS+"selectAccIds");
		return list;
	}

	@Override
	public String selectCardId(String accId) throws Exception {
		return sqlSession.selectOne(NS+"selectCardId", accId);
	}

	@Override
	public int updateCardIssued(String cardId) throws Exception {
		return sqlSession.update(NS+"updateCardIssued", cardId);
	}

	@Override
	public String selectCardDelete(String accId) throws Exception {
		return sqlSession.selectOne(NS+"selectCardDelete", accId);

	}

}
