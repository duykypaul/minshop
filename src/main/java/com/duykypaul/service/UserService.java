package com.duykypaul.service;

import com.duykypaul.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duykypaul.dao.UserDao;
import com.duykypaul.dao.inf.IUser;
import com.duykypaul.entity.User;

@Service
public class UserService implements IUser  {
	
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
