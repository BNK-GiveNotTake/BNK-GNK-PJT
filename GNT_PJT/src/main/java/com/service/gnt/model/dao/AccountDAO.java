package com.service.gnt.model.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.boot.web.servlet.server.Session;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.account.MileageHistory;

public interface AccountDAO {
	void createAcc(int accPassword, String email, String name, String nameEnglish, Date birthday, String address, Number phone);
	int getAccBalance(String accId);
	void depositAcc(int amount);
	void sendAcc(int amount, String accId);
	MileageHistory createMile(MileageHistory vo);
	int getMileBalance(int mileagePk);
	List<MileageHistory> getMileHistory(Session session);
	void addMile(int amount, String accId);
}
