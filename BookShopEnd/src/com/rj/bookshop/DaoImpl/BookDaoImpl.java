package com.rj.bookshop.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rj.bookshop.Dao.BookDao;
import com.rj.bookshop.Entity.Book;

@Repository

public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> select() {		   
		Session session = sessionFactory.getCurrentSession();
		Query<Book> query = session.createQuery("from Book");
		List<Book> list = query.list();
		return list;
	}

	@Override
	public boolean insert(Book book) {
		Session session = sessionFactory.getCurrentSession();
		session.save(book);
		return true;
	}

	@Override
	public boolean update(Book book) {
		Session session = sessionFactory.getCurrentSession();
		session.update(book);
		return true;
	}

	@Override
	public boolean delete(Book book) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(book);
		return true;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Book selectById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Book> query = session.createQuery("from Book where book_id = ?");
		query.setParameter(0,id);
		Book book = query.uniqueResult();
		return book;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Book> likeSelect(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query<Book> query = session.createQuery("from Book where book_name like :name1 "
				+ "or kind.kind_name like :name2" );
		query.setParameter("name1","%"+name+"%");
		query.setParameter("name2","%"+name+"%");
		List<Book> list = query.list();
		return list;
	}

}

