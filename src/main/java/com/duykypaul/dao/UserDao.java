package com.duykypaul.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.duykypaul.dao.inf.IUser;
import com.duykypaul.entity.User;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDao implements IUser{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public Boolean checkLogin(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from User where email='" +email+"' and password='" +password+ "'";
		try {
			User user = (User) session.createQuery(sql).getSingleResult();
			return user != null;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public Boolean addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		Integer user_id = (Integer) session.save(user);
		return user_id > 0;
	}
	
}
