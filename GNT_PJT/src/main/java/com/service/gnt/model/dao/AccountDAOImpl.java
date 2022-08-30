package com.service.gnt.model.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.account.MileageHistory;
import com.service.gnt.domain.users.Users;

@Repository
public class AccountDAOImpl implements AccountDAO{

	public final static String AM = "ns.sql.AccountMapper.";
	private final static String UM = "ns.sql.UserMapper.";
	@Autowired
	private SqlSession sqlSession;
	private CommonDAO commonDAO;

	public void createAcc(int userId, int accPassword, String userEmail, String userNameEng, String address,
			String Phone) {
		String key = "";
		while(true) {
			key = sqlSession.selectOne(AM+"createAccKey");
			if(sqlSession.selectOne(AM+"validateAccId", key).equals("0")) {
				break; //난수생성한 계좌가 겹치지 않을 경우 실행
			};
		}
		sqlSession.insert(AM+"createAcc", new Account(key, accPassword));
		Users vo = new Users(userId, key, userNameEng, address, Phone);
		sqlSession.update(UM+"addUserInfo", vo); //user 정보 추가부
	}
	
	public void createAccTest(int accPassword) {
		System.out.println("CreateAccTest 테스트중");
		String key = "";
		while(true) {
			key = sqlSession.selectOne(AM+"createAccKey");
			if(sqlSession.selectOne(AM+"validateAccId", key).equals("0")) {
				break; //난수생성한 계좌가 겹치지 않을 경우 실행
			};
		}
		sqlSession.insert(AM+"createAcc", new Account(key, accPassword));
	}

	public int getAccBalance(String accId) {
		return sqlSession.selectOne(AM+"getAccBalance", accId);
	}

	public void depositAcc(int userId, int amount) {
		Users user = commonDAO.getUserById(userId);
		sqlSession.update(AM+"depositAcc", new Account(user.getAccId(), null, 0, null, amount, 0));
	}
	public void sendAcc(int userId, int amount, String accId) {
		Users user = commonDAO.getUserById(userId);
		String mainId = user.getAccId();		
		int out = amount * -1;
		if (getAccBalance(mainId) >= amount) {
			sqlSession.update(AM+"manageAcc", new Account(mainId, null, 0, null, out, 0));
			sqlSession.update(AM+"manageAcc", new Account(accId, null, 0, null, amount, 0));
			} else {
			System.out.println("계좌에 잔고가 부족합니다.");
		}
	}

	public void createMile(int userId) {
		Users user = commonDAO.getUserById(userId);
		sqlSession.insert(AM+"createMile", new MileageHistory(0, user.getAccId(), null, 0));
	}

	public int getMileBalance(int mileagePk) {
		return sqlSession.selectOne(AM+"getMileBalance",mileagePk);
	}
	
	public int getMilePk(int userId) {
		/*
		 * Users user = commonDAO.getUserById(userId); return
		 * user.getAccount().getMileage();
		 */
		return 0;
	}

	public List<MileageHistory> getMileHistory(int userId) {
		Users user = commonDAO.getUserById(userId);
		return sqlSession.selectList(AM+"getMileHistory", getMilePk(userId));
	}

	public void addMile(int amount, int userId) {
		Users user = commonDAO.getUserById(userId);
		String accId = user.getAccId();
		if(getAccBalance(accId) >= amount){
			int out = amount * -1;
			sqlSession.update(AM+"manageAcc", new Account(accId, null, 0, null, out, 0));
			sqlSession.update(AM+"addMile", new MileageHistory(getMilePk(userId), user.getAccId(), null, amount));
		}else {
			System.out.println("잔액이 부족합니다.");
		}
	}

}
