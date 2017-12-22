package com.rj.bookshop.DaoImpl;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rj.bookshop.Dao.OrderLineDao;
import com.rj.bookshop.Entity.Book;
import com.rj.bookshop.Entity.Order;
import com.rj.bookshop.Entity.OrderLine;
import com.rj.bookshop.Service.BookService;

@Repository
public class OrderLineDaoImpl implements OrderLineDao {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addOrderLineDao(int bookid,Order order,int count) {
		Session session = sessionFactory.getCurrentSession();
		Book book = bookService.selectBookById(bookid);
		
		Set<OrderLine>orderLineSet = order.getOrderlineSet();
		boolean t = true;
			for(OrderLine ol:orderLineSet) {
				if(ol.getBook().getBook_id()==bookid) {
					ol.setCount(ol.getCount() +count);
					ol.setPrice(ol.getCount()*ol.getBook().getBook_price());
					t=false;
					break;
				}
			}
			if(t) {
				OrderLine orderline = new OrderLine();
				orderline.setBook(book);
				orderline.setOrder(order);
				orderline.setCount(count);
				orderline.setPrice(count*book.getBook_price());
				
				order.getOrderlineSet().add(orderline);
				
				session.save(orderline);
				session.update(order);
			}
		}


	@Override
	public boolean updateOrderLine(OrderLine orderline) {
		Session session = sessionFactory.getCurrentSession();
		session.update(orderline);
		return true;
	}

	@Override
	public boolean deleteOrderLine(OrderLine orderline) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(orderline);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public OrderLine selectOrderLineById(int orderline_id) {
		Session session = sessionFactory.getCurrentSession();
		Query<OrderLine> query = session.createQuery("from OrderLine where orderline_id = ?");
		query.setParameter(0, orderline_id);
		OrderLine orderline = query.uniqueResult();
		return orderline;
	}
	
}
