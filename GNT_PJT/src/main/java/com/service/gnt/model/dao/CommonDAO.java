package com.service.gnt.model.dao;

import com.service.gnt.domain.users.Users;

public interface CommonDAO {
	int insert(Users user);
	Users select(Users user);
}
