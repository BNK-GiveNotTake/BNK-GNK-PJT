package com.service.gnt.model.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Repository;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.account.MileageHistory;
import com.service.gnt.domain.users.Users;

@Repository
public class AccountDAOImpl implements AccountDAO{

	public final static String NS = "ns.sql.AccountMapper.";
	@Autowired
	private SqlSession sqlSession;
	private CommonDAO commonDAO;

	public void createAcc(int userId, int accPassword, String userEmail, String userEngName, String address,
			String userPhone) {
		sqlSession.insert(NS+"createAcc", accPassword);
		Users vo = new Users(userId, null, null, userEngName, userEmail, null, address, userPhone, 0, null, '0');
		sqlSession.update(NS+"addUserInfo", vo); //user 정보 추가부
	}

	public int getAccBalance(String accId) {
		return sqlSession.selectOne(NS+"getAccBalance", accId);
	}

	public void depositAcc(int userId, int amount) {
		Users user = commonDAO.getUserById(userId);
		sqlSession.update(NS+"depositAcc", new Account(user.getAccId(), null, 0, null, amount, 0));
	}
	public void sendAcc(int userId, int amount, String accId) {
		Users user = commonDAO.getUserById(userId);
		String mainId = user.getAccId();		
		int out = amount * -1;
		if (getAccBalance(mainId) >= amount) {
			sqlSession.update(NS+"manageAcc", new Account(mainId, null, 0, null, out, 0));
			sqlSession.update(NS+"manageAcc", new Account(accId, null, 0, null, amount, 0));
			} else {
			System.out.println("계좌에 잔고가 부족합니다.");
		}
	}

	public void createMile(int userId) {
		Users user = commonDAO.getUserById(userId);
		sqlSession.insert(NS+"createMile", new MileageHistory(0, user.getAccId(), null, 0));
	}

	public int getMileBalance(int mileagePk) {
		return sqlSession.selectOne(NS+"getMileBalance",mileagePk);
	}
	
	public int getMilePk(int userId) {
		Users user = commonDAO.getUserById(userId);
		return user.getAccount().getMileage();
	}

	public List<MileageHistory> getMileHistory(int userId) {
		Users user = commonDAO.getUserById(userId);
		return sqlSession.selectList(NS+"getMileHistory", getMilePk(userId));
	}

	public void addMile(int amount, int userId) {
		Users user = commonDAO.getUserById(userId);
		String accId = user.getAccId();
		if(getAccBalance(accId) >= amount){
			int out = amount * -1;
			sqlSession.update(NS+"manageAcc", new Account(accId, null, 0, null, out, 0));
			sqlSession.update(NS+"addMile", new MileageHistory(getMilePk(userId), user.getAccId(), null, amount));
		}else {
			System.out.println("잔액이 부족합니다.");
		}
	}

}
