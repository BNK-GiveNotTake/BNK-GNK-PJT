package com.service.gnt.model.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.account.MileageHistory;
import com.service.gnt.model.dao.AccountDAO;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDAO accountDAO;

	public void createAcc(int accPassword, String email, String name, String nameEnglish, Date birthday, String address,
			Number phone) {
		accountDAO.createAcc(accPassword, email, name, nameEnglish, birthday, address, phone);
	}

	public int getAccBalance(String accId) {
		return accountDAO.getAccBalance(accId);
	}

	public void depositAcc(int amount) {
		accountDAO.depositAcc(amount);
	}

	public void sendAcc(int amount, String accId) {
		accountDAO.sendAcc(amount, accId);
	}

	public MileageHistory createMile(MileageHistory vo) {
		return accountDAO.createMile(vo);
	}

	public int getMileBalance(int mileagePk) {
		return accountDAO.getMileBalance(mileagePk);
	}

	public List<MileageHistory> getMileHistory(Session session) {
		return accountDAO.getMileHistory(session);
	}

	public void addMile(int amount, String accId) {
		accountDAO.addMile(amount, accId);
	}
	
}
