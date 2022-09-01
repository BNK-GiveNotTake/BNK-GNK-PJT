package com.service.gnt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.donation.Donation;
import com.service.gnt.model.dao.DonationDAO;

@Service
public class DonationServiceImpl implements DonationService{

	@Autowired
	private DonationDAO donationDAO;
	
	
	@Override
	public List<Donation> select1() {
		
		return donationDAO.select1();
	}


	@Override
	public List<Donation> select2(int categoryId) {
		
		return donationDAO.select2(categoryId);
	}
	
	@Override
	public List<Donation> select2_1(int k) {
		return donationDAO.select2_1(k);
	}

	@Override
	public Donation select3(String donationId) {
		
		return donationDAO.select3(donationId);
	}


	@Override
	public int update1(Donation donation) {
		
		return donationDAO.update1(donation);
	}


	@Override
	public int update2(Account account) {
		return donationDAO.update2(account);
	}


	@Override
	public Account getAccountByUserId(int userId) {
		
		return donationDAO.getAccountByUserId(userId);
	}


	@Override
	public String getAccIdByUserId(int userId) {

		return donationDAO.getAccIdByUserId(userId);
	}


	@Override
	public Account getAccount(String accId) {

		return donationDAO.getAccount(accId);
	}


	@Override
	public Account setAccountToUpdate(int userId, int donationAmount) {
		return donationDAO.setAccountToUpdate(userId, donationAmount);
	}


	@Override
	public int addMilege(int donationAmount, int userId) {
	
		return donationDAO.addMilege(donationAmount, userId);
	}


	@Override
	public int addDonaHistory(String donationId, int donationAmount, int userId) {
		return donationDAO.addDonaHistory(donationId,donationAmount,userId);
	}
	

}
