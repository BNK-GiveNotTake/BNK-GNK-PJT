package com.service.gnt.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.gnt.domain.users.Users;


@Repository
public class CommonDAOImpl implements CommonDAO{
	
private final static String NS = "ns.sql.UserMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(Users user) {
		System.out.println("DAO 진입");
		int returnInt = sqlSession.insert(NS+"newUser", user);
		System.out.println(returnInt);
		return returnInt;
	}

	public Users select(Users user) {
		return sqlSession.selectOne(NS+"selectUser",user);
	}

	public Users getUserById(int userId) {
		return sqlSession.selectOne(NS+"getUserById",userId);
	}
	
}
