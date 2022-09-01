package com.service.gnt.model.service;

import java.util.List;

import com.service.gnt.domain.donation.Donation;

public interface DonationService {

	List<Donation> select1();
	List<Donation> select2(int categoryId);
	List<Donation> select2_1(int k);
	Donation select3(String donationId);
	int update1(Donation donation);
//	int update2(Donate donate);
//	int insert1(Donate donate);

}
