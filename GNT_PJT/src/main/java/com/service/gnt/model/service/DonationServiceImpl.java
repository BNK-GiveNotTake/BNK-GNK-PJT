package com.service.gnt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.gnt.domain.donation.Donation;
import com.service.gnt.model.dao.DonationDAO;

@Service
public class DonationServiceImpl implements DonationService{

	@Autowired
	private DonationDAO donationDAO;
	
	
	@Override
	public List<Donation> select1() {
		System.out.println("service select()...");
		
		return donationDAO.select1();
	}


	@Override
	public List<Donation> select2(int categoryId) {
		System.out.println("service select()...");
		
		return donationDAO.select2(categoryId);
	}
	
	@Override
	public List<Donation> select2_1(int k) {
		System.out.println("service select()...");
		return donationDAO.select2_1(k);
	}

	@Override
	public Donation select3(String donationId) {
		System.out.println("service select()...");
		
		return donationDAO.select3(donationId);
	}


	@Override
	public int update1(Donation donation) {
		System.out.println("service select()...");
		
		return donationDAO.update1(donation);
	}


//	@Override
//	public 	int update2(Donate donate) {
//		System.out.println("service select()...");
//		return donationDAO.update2(donate);
//	}
//
//
//	@Override
//	public int insert1(Donate donate) {
//		System.out.println("service select()...");
//		return donationDAO.insert1(donate);
//	}



}
