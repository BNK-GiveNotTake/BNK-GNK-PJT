package com.service.gnt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.account.MileageHistory;
import com.service.gnt.model.dao.AccountDAO;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDAO accountDAO;

	public Account createAcc(int userId, int accPassword, String userNameEng,
			String address, String phone) {
		return accountDAO.createAcc(userId, accPassword, userNameEng, address, phone);
	}

	public int getAccBalance(String accId) {
		return accountDAO.getAccBalance(accId);
	}

	public void depositAcc(int userId, int amount) {
		accountDAO.depositAcc(userId, amount);
	}

	public void sendAcc(int userId, int amount, String accId) {
		accountDAO.sendAcc(userId, amount, accId);
	}

	public int createMile(int userId) {
		return accountDAO.createMile(userId);
	}

	public int getMileBalance(int userId) {
		return accountDAO.getMileBalance(userId);
	}

	public List<MileageHistory> getMileHistory(int userId) {
		return accountDAO.getMileHistory(userId);
	}

	public MileageHistory addMile(int amount, int userId) {
		return accountDAO.addMile(amount, userId);
	}

	public int getMilePk(int userId) {
		return accountDAO.getMilePk(userId);
	}

	public Account createAccTest(int accPassword) {
		return accountDAO.createAccTest(accPassword);
	}

	public Account getAccount(String accId) {
		return accountDAO.getAccount(accId);
	}
	
	public String checkUserAcc(int userId) {
		return accountDAO.checkUserAcc(userId);
	}
	public Account getAccountByUserId(int userId) {
		return accountDAO.getAccountByUserId(userId);
	}
}
