package com.service.gnt.model.dao;

import java.util.List;

import com.service.gnt.domain.donation.Donation;

public interface DonationDAO {
	
	List<Donation> select1();
	List<Donation> select2();

}
