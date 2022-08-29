package com.service.gnt.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.gnt.domain.users.Users;


@Repository
public class CommonDAOImpl implements CommonDAO{

	public final static String NS = "ns.sql.UserMapper.";
	@Autowired
	private SqlSession sqlSession;
	public Users getUserById(int userId) {
		return sqlSession.selectOne(NS+"getUserById",userId);
	}
}
