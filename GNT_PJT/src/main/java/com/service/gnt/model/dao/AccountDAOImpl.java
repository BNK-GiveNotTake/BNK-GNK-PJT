package com.service.gnt.model.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Repository;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.account.MileageHistory;

@Repository
public class AccountDAOImpl implements AccountDAO{

	public final static String NS = "ns.sql.AccountMapper.";
	@Autowired
	private SqlSession sqlSession;

	public void createAcc(int accPassword, String email, String name, String nameEnglish, Date birthday, String address,
			Number phone) {
		sqlSession.insert(NS+"createAcc", accPassword);
		//user date 수정관련 내용도 추가 필요
	}

	public int getAccBalance(String accId) {
		
		return sqlSession.selectOne(NS+"getAccBalance", accId);
	}

	public void depositAcc(int amount) {
		
		
	}

	public void sendAcc(int amount, String accId) {
		
		
	}

	public MileageHistory createMile(MileageHistory vo) {
		
		return null;
	}

	public int getMileBalance(int mileagePk) {
		
		return 0;
	}

	public List<MileageHistory> getMileHistory(Session session) {
		
		return null;
	}

	public void addMile(int amount, String accId) {
		
		
	}
}
