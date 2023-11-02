package com.DigiDocker.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.DigiDocker.entity.Documents;
import com.DigiDocker.entity.User;

@Transactional
@Repository
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

		String sql = "from User where email=:em and password=:pwd";

		User user=(User)hibernateTemplate.execute(s -> {
			@SuppressWarnings({ "rawtypes" })
			Query q = s.createQuery(sql);
			q.setParameter("em", email);
			q.setParameter("pwd", password);
			return q.uniqueResult();
		});

		return user;
	}

	@Override
	public int saveDocuments(Documents documents) {
		
		int i = (Integer) hibernateTemplate.save(documents);
		return i;		
	}

	@Override
	public List<Documents> getDocumentsByUser(User user) {
		
		return null;
	}

	@Override
	public Documents getDocumentsById(int id) {
		Documents n = hibernateTemplate.get(Documents.class, id);
		return n;
	}

	@Override
	public void deleteDocuments(int id) {		
		Documents n = hibernateTemplate.get(Documents.class, id);
		hibernateTemplate.delete(n);
		
	}
}
