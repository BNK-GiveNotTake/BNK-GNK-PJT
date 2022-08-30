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
	public List<Donation> select() {
		System.out.println("service select()...");
		
		return donationDAO.select();
		
	}
	


}
