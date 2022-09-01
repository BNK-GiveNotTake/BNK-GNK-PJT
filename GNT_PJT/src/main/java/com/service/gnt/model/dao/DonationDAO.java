package com.service.gnt.model.dao;

import java.util.List;
import java.util.Map;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.donation.Donation;

public interface DonationDAO {
	
	List<Donation> select1();
	List<Donation> select2(int categoryId);
	List<Donation> select2_1(int k);
	Donation select3(String donationId);
	int update1(Donation donation);
	int update2(Account account);
	Account getAccountByUserId(int userId);
	String getAccIdByUserId(int userId);
	Account getAccount(String accId);
	Account setAccountToUpdate(int userId, int donationAmount);

	
}
