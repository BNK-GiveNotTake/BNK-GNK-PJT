package com.service.gnt.model.service;

import java.util.List;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.donation.Donation;

public interface DonationService {

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
	int addMilege(int donationAmount, int userId);
	int addDonaHistory(String donationId, int donationAmount, int userId);
	
}
