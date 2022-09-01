package com.service.gnt.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.account.MileageHistory;
import com.service.gnt.domain.users.Users;

@Repository
public class AccountDAOImpl implements AccountDAO {

	public final static String AM = "ns.sql.AccountMapper.";
	private final static String UM = "ns.sql.UserMapper.";
	@Autowired
	private SqlSession sqlSession;
	private CommonDAO commonDAO;

	public Account createAcc(int userId, String accPassword, String userNameEng, String address,
			String phone) {
		String key = "";
		while (true) {
			key = sqlSession.selectOne(AM + "createAccKey");
			if (sqlSession.selectOne(AM + "validateAccId", key).equals("0")) {
				break; // 난수생성한 계좌가 겹치지 않을 경우 실행
			}
		}
//		System.out.println(accPassword);
		sqlSession.insert(AM + "createAcc", new Account(key, accPassword));
		
		Users vo = new Users(userId, key, userNameEng, address, phone);
		sqlSession.update(UM + "addUserInfo", vo); // user 정보 추가부
		return getAccount(key);
	}

	public Account createAccTest(String accPassword) {
//		System.out.println("CreateAccTest 테스트중");
		String key = "";
		while (true) {
			key = sqlSession.selectOne(AM + "createAccKey");
			if (sqlSession.selectOne(AM + "validateAccId", key).equals("0")) {
				break; // 난수생성한 계좌가 겹치지 않을 경우 실행
			}
		}
		sqlSession.insert(AM + "createAcc", new Account(key, accPassword));
		return getAccount(key);
	}

	public int getAccBalance(String accId) {
		return sqlSession.selectOne(AM + "getAccBalance", accId);
	}

	public int depositAcc(int userId, int amount) {
		return sqlSession.update(AM + "manageAcc", new Account(getAccIdByUserId(userId), amount, 0));
	}

	public String sendAcc(int userId, int amount, String accId) {
		String mainId = getAccIdByUserId(userId);
		String data = "no";
		int out = amount * -1;
		if (getAccBalance(mainId) >= amount) {
			sqlSession.update(AM + "manageAcc", new Account(mainId, out, 0));
			sqlSession.update(AM + "manageAcc", new Account(accId, amount, 0));
			data = "yes";
		} else {
//			System.out.println("계좌에 잔고가 부족합니다.");
		}
		return data;
	}

	public int createMile(int userId) {
		String accId = sqlSession.selectOne(UM+"getAccIdByUserId",userId);
//		System.out.println(accId);
		return sqlSession.insert(AM + "createMile", accId);
	}

	public int getMileBalance(int userId) {
		String accId = getAccIdByUserId(userId);
		return sqlSession.selectOne(AM + "getMileBalance", accId);
	}
	
	public Account getAccount(String accId) {
		return sqlSession.selectOne(AM+"getAccount",accId);
	}
	
	public Account getAccountByUserId(int userId) {
		return getAccount(getAccIdByUserId(userId));
	}
	
	public String getAccIdByUserId(int userId) {
		return sqlSession.selectOne(UM+"getAccIdByUserId",userId);
	}

	public int getMilePk(int userId) { // 없애도 되는 메소드...
		 Users user = commonDAO.getUserById(userId);
		 return getAccount(user.getAccId()).getMileage();
	}

	public List<MileageHistory> getMileHistory(int userId) {
		return sqlSession.selectList(AM + "getMileageHistory", getAccIdByUserId(userId));
	}

	public MileageHistory addMile(int type, int userId) {
		int amount = 0;
		int bonus = 0;
		String accId = sqlSession.selectOne(UM+"getAccIdByUserId",userId);
		switch(type) {
		case 1:
			amount = 10000;
			break;
		case 2:
			amount = 30000;
			bonus = 3000;
			break;
		case 3:
			amount = 50000;
			bonus = 5000;
			break;
		case 4:
			amount = 100000;
			bonus = 10000;
			break;
		default :
			break;
		}
		if (getAccBalance(accId) >= amount) {
			int out = amount * -1;
			int total = amount + bonus;
			String message = "";
			if(total>0) message="충전";
			sqlSession.update(AM + "manageAcc", new Account(accId, out, 0));
			sqlSession.update(AM + "addMile", new Account(accId, 0, total));
			sqlSession.insert(AM+"addMileHistory", new MileageHistory(accId,total,message));
			return sqlSession.selectOne(AM+"getLastMileHistory", accId);
		} else {
//			System.out.println("잔액이 부족합니다.");
			return null;
		}
	}
	
	public String checkUserAcc(int userId) {
		String str = "no";
		/*
//		System.out.println("err 어딜까");
		Users user = commonDAO.getUserById(userId);
//		System.out.println("err 여긴가");
		user.getAccId().equals(null) || user.getAccId() == null
		*/
		
		if(sqlSession.selectOne(AM+"checkUserAcc",userId).equals("0")) str = "no";
		else str = "yes";
		return str;
	}

	public int getMileHistoryAMT(int userId) {
		String accId = sqlSession.selectOne(UM+"getAccIdByUserId",userId);
		return sqlSession.selectOne(AM+"getMileHistoryAMT",accId);
	}

}
