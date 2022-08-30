package com.service.gnt;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.users.Users;

public class MyBatisTest {
	@Test
	public void unit() throws Exception {
		String um = "ns.sql.UserMapper.";
		String am = "ns.sql.AccountMapper.";
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		Users user = new Users("aa@naver.com", "AAA", "12355");
		System.out.println(user.toString());
		int returnInsert = session.insert(um+"newUser", user);
//		session.commit();
		
		
		System.out.println(returnInsert);
		System.out.println("createAcc Method Unit Test");
		int userId = Integer.parseInt(session.selectOne(um+"getUserId",user));
		System.out.println("User Id : "+userId);
				//user.getUserId();
		String accId = "";
		while(true) {
			accId = session.selectOne(am+"createAccKey");
			if(session.selectOne(am+"validateAccId", accId).equals("0")) {
				break; //난수생성한 계좌가 겹치지 않을 경우 실행
			};
		}
		System.out.println(accId);
		session.insert(am+"createAcc", new Account(accId, 151515));
		
//		session.commit();
		
		
		Users vo = new Users(userId, accId, "EngName", "산포시", "01012341234");
		session.update(um+"addUserInfo", vo);
		
		session.commit();
	}
	
}
