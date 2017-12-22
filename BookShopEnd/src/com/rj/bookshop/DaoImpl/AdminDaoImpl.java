package com.rj.bookshop.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rj.bookshop.Dao.AdminDao;
import com.rj.bookshop.Entity.Admin;
@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> adminLogin(String adminname, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query<Admin> query = session.createQuery("from Admin where name=? and password=?");
		query.setParameter(0, adminname);
		query.setParameter(1, password);
		
		return query.list();
	}

	@Override
	public boolean adminUpdate(Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		session.update(admin);
		return false;
	}

}
