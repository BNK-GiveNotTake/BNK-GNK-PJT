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
		int returnInt = sqlSession.insert(NS+"newUser", user);
		return returnInt;
	}

	public Users select(Users user) {
		return sqlSession.selectOne(NS+"selectUser",user);
	}

	public Users select01(Users user) {
		return sqlSession.selectOne(NS+"newUser_email",user);
	}
	
	
	public Users getUserById(int userId) {
		return sqlSession.selectOne(NS+"getUserById",userId);
	}
	
}
