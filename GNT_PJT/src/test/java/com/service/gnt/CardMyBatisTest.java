package com.service.gnt;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.card.Card;
import com.service.gnt.domain.event.Quiz;

@RunWith(SpringRunner.class)
@SpringBootTest
class CardMyBatisTest {
	
	// card test (myBatis) ----------------------------------------------------------------------
	@Test
	void insertCardTest() throws Exception {
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		Card card = new Card("1234567890123456", 456, "", "", 0, 0, 0, "", ""); // card 생성자 입력
		
		int result = session.insert("ns.sql.CardMapper.insertCard",card);
		
		System.out.println("Card Test :: insertCard? ----------> "+result);
		session.commit();
	}
	
	@Test
	void selectAccIdTest() throws Exception {
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		String userId = "57"; // userId 입력
		
		String accId = session.selectOne("ns.sql.CardMapper.selectAccId", userId);
		
		System.out.println("Card Test :: selectAccId? ----------> "+accId);
		session.commit();
	}
	
	@Test
	void updateCardToAccTest() throws Exception {
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		Account account = new Account("4223616120041","1234567890123456",""); // account 집어넣기
		int result = session.update("ns.sql.CardMapper.updateCardToAcc", account);
		
		System.out.println("Card Test :: updateCardToAcc? ----------> "+result);
		session.commit();
	}
	
	@Test
	void deleteCardTest() throws Exception {
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		String cardId = "1234567890123456"; // 카드번호 입력
		int result = session.delete("ns.sql.CardMapper.deleteCard", cardId);
		
		System.out.println("Card Test :: deleteCard? ----------> "+result);
		session.commit();
	}
	
	@Test
	void selectAccIdsTest() throws Exception {
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		List<String> list = session.selectList("ns.sql.CardMapper.selectAccIds","57");
		
		for (String accId: list) {
			System.out.println("Card Test :: selectAccIds? ----------> "+accId+" (List)");
		}
		session.commit();
	}
	
	
	@Test
	void selectCardIdTest() throws Exception {
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		String accId = "4223616120041"; // 계좌번호 입력
		String result = session.selectOne("ns.sql.CardMapper.selectCardId", accId);
		
		System.out.println("Card Test :: selectCardId? ----------> "+result);
		session.commit();
	}
	
	@Test
	void updateCardIssuedTest() throws Exception {
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		String cardId = "1234567890123456"; // 카드번호
		int result = session.update("ns.sql.CardMapper.updateCardIssued", cardId);
		
		System.out.println("Card Test :: updateCardIssued? ----------> "+result);
		session.commit();
	}
	
	@Test
	void selectCardDeleteTest() throws Exception {
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		String accId = "4223616120041"; // 계좌번호 입력
		String cardId = session.selectOne("ns.sql.CardMapper.selectCardDelete", accId);
		
		System.out.println("Card Test :: selectCardDelete? ----------> "+cardId);
		session.commit();
	}
	

}
