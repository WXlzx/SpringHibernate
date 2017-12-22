package com.rj.bookshop.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rj.bookshop.Dao.KindDao;
import com.rj.bookshop.Entity.Kind;

@Repository
public class KindDaoImpl implements KindDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Kind> select() {
		Session session = sessionFactory.getCurrentSession();
		Query<Kind> query = session.createQuery("from Kind");
		List<Kind> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Kind selectById(int kind_id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Kind> query = session.createQuery("from Kind where kind_id = ?");
		query.setParameter(0,kind_id);
		Kind kind = query.uniqueResult();
		return kind;
	}

	@Override
	public boolean insert(Kind kind) {
		Session session = sessionFactory.getCurrentSession();
		session.save(kind);
		return true;
	}

	@Override
	public boolean update(Kind kind) {
		Session session = sessionFactory.getCurrentSession();
		session.update(kind);
		return true;
	}

	@Override
	public boolean delete(Kind kind) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(kind);
		return true;
	}

}
