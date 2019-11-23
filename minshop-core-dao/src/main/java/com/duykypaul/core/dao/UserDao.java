package com.duykypaul.core.dao;

import com.duykypaul.core.inf.IUser;
import com.duykypaul.core.persistence.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDao implements IUser {
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

	@Override
	@Transactional
	public List<User> getListUser() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from User";
		try {
			List<User> userList = (List<User>) session.createQuery(sql).getResultList();
			return userList;
		} catch (Exception e) {
			return null;
		}
	}

    @Override
	@Transactional
    public void removeUserById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
//        session.delete(user);
		session.createQuery("delete from User where user_id=" + id).executeUpdate();
    }

	@Override
	public void updateUser(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		session.update(user);
	}

	@Override
	public User getUserById(Integer id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

}
