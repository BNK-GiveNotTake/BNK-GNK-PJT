package com.service.gnt.model.dao;

import java.util.List;

import com.service.gnt.domain.account.MileageHistory;

public interface AccountDAO {
	public void createAcc(int userId, int accPassword, String userEmail, String userNameEng, String address,
			String Phone);
	public int getAccBalance(String accId);
	public void depositAcc(int userId, int amount);
	public void sendAcc(int userId, int amount, String accId);
	public void createMile(int userId);
	public int getMileBalance(int mileagePk);
	public List<MileageHistory> getMileHistory(int userId);
	public void addMile(int amount, int userId);
	public int getMilePk(int userId);
	public void createAccTest(int accPassword); //테스트용 지울거임
}
