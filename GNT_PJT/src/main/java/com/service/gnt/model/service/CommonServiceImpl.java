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
	public Users getUserById(int userId) {
		return commonDAO.getUserById(userId);
	}
	


}
