package com.service.gnt.model.dao;

import java.util.List;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.account.MileageHistory;

public interface AccountDAO {
	Account createAcc(int userId, String accPassword, String userNameEng, String address,
			String phone);
	int getAccBalance(String accId);
	int depositAcc(int userId, int amount);
	String sendAcc(int userId, int amount, String accId);
	int createMile(int userId);
	int getMileBalance(int userId);
	List<MileageHistory> getMileHistory(int userId);
	MileageHistory addMile(int amount, int userId);
	int getMilePk(int userId);
	Account getAccount(String accId);
	Account createAccTest(String accPassword); //테스트용 지울거임
	String checkUserAcc(int userId);
	Account getAccountByUserId(int userId);
	int getMileHistoryAMT(int userId);
	String getAccIdByUserId(int userId);
}
