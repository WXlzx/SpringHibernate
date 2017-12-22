package com.rj.bookshop.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rj.bookshop.Dao.OrderDao;
import com.rj.bookshop.Entity.Order;
import com.rj.bookshop.Entity.OrderLine;
import com.rj.bookshop.Entity.User;
import com.rj.bookshop.Service.UserService;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private UserService userService;
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Order addOrderDao(int userid) {
		Session session = sessionFactory.getCurrentSession();
		User user = userService.selectUserById(userid);
		Order order = null;
		if(user.getOrderSet().size()<=0) {
			order = new Order();
		}else {
			for(Order o : user.getOrderSet()) {
				if(o.getState()==1) {
					order = o;
					break;
				}
				order = new Order();
			}
			
		}
		
		order.setState(1);
		order.setUser(user);
		
		user.getOrderSet().add(order);
		
		session.update(user);	
		session.save(order);
		return order;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> selectOrder() {
		Session session = sessionFactory.getCurrentSession();
		Query<Order> query = session.createQuery("from Order");
		List<Order> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Order selectOrderById(int order_id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Order> query = session.createQuery("from Order where order_id = ?");
		query.setParameter(0, order_id);
		Order order = query.uniqueResult();
		return order;
	}
	
	@Override
	public boolean updateOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.update(order);
		return true;
	}
	
	public void deleteAll(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(order);
	}
}
