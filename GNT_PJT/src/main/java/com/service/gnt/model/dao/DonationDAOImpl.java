package com.service.gnt.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.gnt.domain.donation.Donation;

@Repository
public class DonationDAOImpl implements DonationDAO{
	
	private final String NS = "ns.sql.DonationMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public List<Donation> select1() {
		System.out.println("dao select()...");
		
		return sqlSession.selectList(NS+"DonationAsk", null);
		
	}

	@Override
	public List<Donation> select2(int categoryId) {
		System.out.println("dao select().....");
		
		return sqlSession.selectList(NS+"CategoryPage",categoryId);
	}
	
	@Override
	public List<Donation> select2_1(int k) {
		System.out.println("dao select().....");
		
		return sqlSession.selectList(NS+"DonationPage",k);
	}

	@Override
	public Donation select3(String donationId) {
		System.out.println("dao select().....");
		
		return sqlSession.selectOne(NS+"detailDonation",donationId);
	}

	@Override
	public int update1(Donation donation) {
		System.out.println("dao select().....");
		return sqlSession.update(NS+"UpdateDonaAmount",donation);
	}

//	@Override
//	public int update2(Donate donate) {
//		System.out.println("dao select().....");
//		return sqlSession.update(NS+"UpdateMileage",donate);
//	}
//	
//
//	@Override
//	public int insert1(Donate donate) {
//		System.out.println("dao select().....");
//		return sqlSession.insert(NS+"DonationHistory",donate);
//		
//	}
	
	
	

}
