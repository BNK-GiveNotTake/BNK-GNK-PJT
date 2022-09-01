package com.service.gnt;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.card.Card;
import com.service.gnt.domain.event.Quiz;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventMyBatisTest {
	
	
	// Event test (myBatis) ----------------------------------------------------------------------
	
	@Test
	public void selectQuizCKTest() throws Exception {
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		String userId = ""; // userId 입력
		String check = session.selectOne("ns.sql.EventMapper.selectQuizCK", userId);
		
		System.out.println("Event Test :: selectQuizCK? ----------> "+check);
		
	}
	
	@Test
	public void selectQuizIdTest() throws Exception {
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		String userId = ""; // userId 입력
		String quizId = session.selectOne("ns.sql.EventMapper.selectQuizId", userId);
		
		System.out.println("Event Test :: selectQuizId? ----------> "+quizId);
		
	}
	
	@Test
	public void selectQuizTest() throws Exception {
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		String quizId = ""; // quizId 입력
		Quiz quiz = session.selectOne("ns.sql.EventMapper.selectQuiz", quizId);
		
		System.out.println("Event Test :: selectQuiz? ----------> "+quiz);
		
	}
	
	@Test
	public void selectQuizAnswerTest() throws Exception {
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		String quizId = ""; // quizId 입력
		int answer = session.selectOne("ns.sql.EventMapper.selectQuizAnswer", quizId);
		
		System.out.println("Event Test :: selectQuizAnswer? ----------> "+answer);
		
	}
	
	@Test
	public void updateQuizUserTest() throws Exception {
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		String userId = ""; // userId 입력
		int result = session.update("ns.sql.EventMapper.updateQuizUser", userId);
		
		System.out.println("Event Test :: updateQuizUser? ----------> "+result);
		
	}
	
	@Test
	public void updateQuizResetTest() throws Exception {
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		int result = session.update("ns.sql.EventMapper.updateQuizReset");
		
		System.out.println("Event Test :: updateQuizReset? ----------> "+result);
		
	}
	
	@Test
	public void selectAllUserIdTest() throws Exception {
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		List<Integer> list = session.selectList("ns.sql.EventMapper.selectAllUserId");
		
		
		for (int userId: list) {
			System.out.println("Event Test :: selectAllUserId? ----------> "+userId+" (List)");
		}
		
		
	}
	
	
	
	
	
	

}
