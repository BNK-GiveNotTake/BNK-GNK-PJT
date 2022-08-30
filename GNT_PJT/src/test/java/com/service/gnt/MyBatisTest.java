package com.service.gnt;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.gnt.domain.users.Users;

public class MyBatisTest {
	
	@Test
	public void unit() throws Exception {
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		Users user = new Users("aa@naver.com", "AAA", "12355");
		System.out.println(user.toString());
		int returnInsert = session.insert("ns.sql.AccountMapper.newUser", user);
		System.out.println(returnInsert);
		session.commit();
	}
	
}
