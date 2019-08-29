package com.duykypaul.core.inf;

import com.duykypaul.core.persistence.entity.User;

public interface IUser {
	Boolean checkLogin(String email, String password);
	Boolean addUser(User user);
}
