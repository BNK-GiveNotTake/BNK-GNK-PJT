package com.service.gnt.model.dao;

import java.util.List;

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
	public List<Donation> select2() {
		System.out.println("dao select()...");
		
		return sqlSession.selectList(NS+"DonationAsk", null);
	}
	
	
	

}
