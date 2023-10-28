package com.DigiDocker.dao;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.DigiDocker.entity.User;


public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public int saveUser(User user) {
		int i = (Integer) hibernateTemplate.save(user);
		return i;
	}

	@Override
	public User login(String email, String password) {

		String sql = "from User where email:em and password:pwd";

		User user=(User)hibernateTemplate.execute(s -> {
			@SuppressWarnings({ "deprecation", "rawtypes" })
			Query q = s.createQuery(sql);
			q.setParameter("em", email);
			q.setParameter("pwd", password);
			return q.uniqueResult();
		});

		return user;
	}

}
