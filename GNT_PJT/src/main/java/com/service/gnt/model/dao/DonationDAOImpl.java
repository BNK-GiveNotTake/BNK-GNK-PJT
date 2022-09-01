package com.service.gnt.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.account.MileageHistory;
import com.service.gnt.domain.donation.Donation;
import com.service.gnt.domain.donation.DonationHistory;

@Repository
public class DonationDAOImpl implements DonationDAO{
	
	private final String NS = "ns.sql.DonationMapper.";
	public final String UM = "ns.sql.UserMapper.";
	public final String AM = "ns.sql.AccountMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public List<Donation> select1() {

		
		return sqlSession.selectList(NS+"DonationAsk", null);
		
	}

	@Override
	public List<Donation> select2(int categoryId) {
		
		
		return sqlSession.selectList(NS+"CategoryPage",categoryId);
	}
	
	@Override
	public List<Donation> select2_1(int k) {
	
		
		return sqlSession.selectList(NS+"DonationPage",k);
	}

	@Override
	public Donation select3(String donationId) {
		
		
		return sqlSession.selectOne(NS+"detailDonation",donationId);
	}

	@Override
	public int update1(Donation donation) {
		
		return sqlSession.update(NS+"UpdateDonaAmount",donation);
	}
	
	@Override
	public int update2(Account account) {
		
		return sqlSession.update(NS+"UpdateMileage",account);
	}
	
	
	@Override
	public Account getAccountByUserId(int userId) {
		return getAccount(getAccIdByUserId(userId));
	}
	
	@Override
	public String getAccIdByUserId(int userId) {
		return sqlSession.selectOne(UM+"getAccIdByUserId",userId);
	}
	
	@Override
	public Account getAccount(String accId) {
		return sqlSession.selectOne(AM+"getAccount",accId);
	}
	
	@Override
	public Account setAccountToUpdate(int userId, int donationAmount) {
		Account acc1 = getAccountByUserId(userId);
		acc1.setMileage(acc1.getMileage()-donationAmount);
		return acc1;
	}
	
	@Override
	public int addMilege(int donationAmount, int userId) {
		String accId1 = getAccIdByUserId(userId);
		
	return sqlSession.insert(AM+"addMileHistory", new MileageHistory(accId1,(-1)*donationAmount,"기부"));
	}
	
	@Override
	public int addDonaHistory(String donationId, int donationAmount, int userId) {
	
		return sqlSession.insert(NS+"DonationHistory", new DonationHistory(donationId, donationAmount,userId));
	}
	
	
}
