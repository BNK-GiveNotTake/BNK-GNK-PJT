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

	public Account createAcc(int userId, int accPassword, String userNameEng, String address,
			String phone) {
		String key = "";
		while (true) {
			key = sqlSession.selectOne(AM + "createAccKey");
			if (sqlSession.selectOne(AM + "validateAccId", key).equals("0")) {
				break; // 난수생성한 계좌가 겹치지 않을 경우 실행
			}
		}
		sqlSession.insert(AM + "createAcc", new Account(key, accPassword));
		Users vo = new Users(userId, key, userNameEng, address, phone);
		sqlSession.update(UM + "addUserInfo", vo); // user 정보 추가부
		return getAccount(key);
	}

	public Account createAccTest(int accPassword) {
		System.out.println("CreateAccTest 테스트중");
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

	public void depositAcc(int userId, int amount) {
		Users user = commonDAO.getUserById(userId);
		sqlSession.update(AM + "depositAcc", new Account(user.getAccId(), null, 0, null, amount, 0));
	}

	public void sendAcc(int userId, int amount, String accId) {
		Users user = commonDAO.getUserById(userId);
		String mainId = user.getAccId();
		int out = amount * -1;
		if (getAccBalance(mainId) >= amount) {
			sqlSession.update(AM + "manageAcc", new Account(mainId, null, 0, null, out, 0));
			sqlSession.update(AM + "manageAcc", new Account(accId, null, 0, null, amount, 0));
		} else {
			System.out.println("계좌에 잔고가 부족합니다.");
		}
	}

	public int createMile(int userId) {
		return sqlSession.insert(AM + "createMile", commonDAO.getUserById(userId).getAccId());
	}

	public int getMileBalance(int userId) {
		String accId = commonDAO.getUserById(userId).getAccId();
		return sqlSession.selectOne(AM + "getMileBalance", accId);
	}
	
	public Account getAccount(String accId) {
		return sqlSession.selectOne(AM+"getAccount",accId);
	}
	
	public Account getAccountByUserId(int userId) {
		//String accId = ;
		//System.out.println(accId);
		return getAccount(sqlSession.selectOne(UM+"getAccIdByUserId",userId));
	}

	public int getMilePk(int userId) { // 없애도 되는 메소드...
		 Users user = commonDAO.getUserById(userId);
		 return getAccount(user.getAccId()).getMileage();
	}

	public List<MileageHistory> getMileHistory(int userId) {
		Users user = commonDAO.getUserById(userId);
		return sqlSession.selectList(AM + "getMileHistory", user.getAccId());
	}

	public MileageHistory addMile(int type, int userId) {
		int amount = 0;
		int bonus = 0;
		Users user = commonDAO.getUserById(userId);
		String accId = user.getAccId();
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
		default:
			break;
		}
		if (getAccBalance(accId) >= amount) {
			int out = amount * -1;
			int total = amount + bonus;
			sqlSession.update(AM + "manageAcc", new Account(accId, null, 0, null, out, 0));
			sqlSession.update(AM + "addMile", new Account(accId, null, 0, null, 0, total));
			sqlSession.insert(AM+"addMileHistory", new MileageHistory(0,accId,"",total,total+" 충전"));
			return sqlSession.selectOne(AM+"getLastMileHistory", accId);
		} else {
			System.out.println("잔액이 부족합니다.");
			return null;
		}
	}
	
	public String checkUserAcc(int userId) {
		String str = "no";
		/*
		System.out.println("err 어딜까");
		Users user = commonDAO.getUserById(userId);
		System.out.println("err 여긴가");
		user.getAccId().equals(null) || user.getAccId() == null
		*/
		
		if(sqlSession.selectOne(AM+"checkUserAcc",userId).equals("0")) str = "no";
		else str = "yes";
		return str;
	}

}
