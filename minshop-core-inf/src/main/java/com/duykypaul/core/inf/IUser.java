package com.duykypaul.core.inf;

import com.duykypaul.core.persistence.entity.User;

import java.util.List;

public interface IUser {
	Boolean checkLogin(String email, String password);
	Boolean addUser(User user);
	List<User> getListUser();
}
