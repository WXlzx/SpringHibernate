package com.rj.bookshop.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rj.bookshop.Dao.UserDao;
import com.rj.bookshop.Entity.User;

@Repository

public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> loginDao(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User where username=? and password=?");
		query.setParameter(0, username);
		query.setParameter(1, password);
		List<User> user = query.list();
		return user;
	}
	@SuppressWarnings("unchecked")
	public List<User> selectUser(){
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User");
		List<User> list = query.list();
		return list;
	}
	@Override
	public boolean registerDao(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
			return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User selectUserById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User where id=?");
		query.setParameter(0, id);
		User user = query.uniqueResult();
		return user;
	}

}
