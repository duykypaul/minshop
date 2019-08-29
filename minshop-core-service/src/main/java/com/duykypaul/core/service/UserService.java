package com.duykypaul.core.service;

import com.duykypaul.core.dao.UserDao;
import com.duykypaul.core.inf.IUser;
import com.duykypaul.core.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUser {
	@Autowired
	UserDao userDao;

	@Override
	public Boolean checkLogin(String email, String password) {
		return userDao.checkLogin(email, password);
	}

	@Override
	public Boolean addUser(User user) {
		return userDao.addUser(user);
	}
	
}
