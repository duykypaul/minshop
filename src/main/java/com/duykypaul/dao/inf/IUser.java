package com.duykypaul.dao.inf;

import com.duykypaul.entity.User;

public interface IUser {
	Boolean checkLogin(String email, String password);
	Boolean addUser(User user);
}
