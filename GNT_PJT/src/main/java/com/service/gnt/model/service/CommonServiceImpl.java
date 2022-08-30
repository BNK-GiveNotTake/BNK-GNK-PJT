package com.service.gnt.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.gnt.domain.users.Users;
import com.service.gnt.model.dao.CommonDAO;

@Service
public class CommonServiceImpl implements CommonService{
	
	@Autowired
	private CommonDAO commonDAO;

	@Override
	public int insert(Users user) {
		return commonDAO.insert(user);
	}

	@Override
	public Users select(Users user) {
		return commonDAO.select(user);
	}
	
	@Override
	public Users getUserById(int userId) {
		return commonDAO.getUserById(userId);
	}
	
	
}
