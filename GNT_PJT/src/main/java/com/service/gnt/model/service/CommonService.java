package com.service.gnt.model.service;

import com.service.gnt.domain.users.Users;



public interface CommonService {
	
	int insert(Users user);
	Users select(Users user);
	

}
