package com.service.gnt;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.users.Users;

public class AccountMyBatisTest {
	@Test
	public void createAcc() throws Exception {
		String um = "ns.sql.UserMapper.";
		String am = "ns.sql.AccountMapper.";
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		System.out.println("createAcc Method Unit Test");
		Users user = new Users("aa@naver.com", "AAA", "12355");
		int userId = session.selectOne(um+"getUserId",user); //테스트할 유저 이메일, 이름, 비밀번호를 입력하거나 userId를 넣어주세요.
		System.out.println("User Id : "+userId);
		String accId = "";
		while(true) {
			accId = session.selectOne(am+"createAccKey");
			if(session.selectOne(am+"validateAccId", accId).equals("0")) {
				break; //난수생성한 계좌가 겹치지 않을 경우 실행
			};
		}
		System.out.println(accId);
		session.insert(am+"createAcc", new Account(accId, 151515));
		Users vo = new Users(userId, accId, "EngName", "산포시", "01012341234");
		session.update(um+"addUserInfo", vo);
		
		session.commit();
	}
	
	
	
}
