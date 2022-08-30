package com.service.gnt.model.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.boot.web.servlet.server.Session;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.account.MileageHistory;
import com.service.gnt.domain.users.Users;

public interface AccountDAO {
	public void createAcc(int userId, int accPassword, String userEmail, String userEngName, String address,
			String userPhone);
	public int getAccBalance(String accId);
	public void depositAcc(int userId, int amount);
	public void sendAcc(int userId, int amount, String accId);
	public void createMile(int userId);
	public int getMileBalance(int mileagePk);
	public List<MileageHistory> getMileHistory(int userId);
	public void addMile(int amount, int userId);
	public int getMilePk(int userId);
}
