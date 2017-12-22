package com.rj.bookshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rj.bookshop.Dao.OrderDao;
import com.rj.bookshop.Dao.OrderLineDao;
import com.rj.bookshop.Entity.Order;
import com.rj.bookshop.Entity.OrderLine;

@Service
@Transactional
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderLineDao orderLineDao;
	
	public void addOrder(int userid,int bookid,int count) {
		Order order = orderDao.addOrderDao(userid);
		orderLineDao.addOrderLineDao(bookid,order,count);
	}
	
	public void updatOrder(Order order,OrderLine orderline) {
		orderDao.updateOrder(order);
		orderLineDao.updateOrderLine(orderline);
	}
	
	public void updateOrder(Order order) {
		orderDao.updateOrder(order);
	}
	
	public void deleteOrder(OrderLine orderline) {
		orderLineDao.deleteOrderLine(orderline);
	}
	
	public void deleteAll(Order order) {
		orderDao.deleteAll(order);
	}
	
	public Order selectOrderById(int order_id) {
		return orderDao.selectOrderById(order_id);
	}
	
	public OrderLine selectOrderLineById(int orderline_id) {
		return orderLineDao.selectOrderLineById(orderline_id);
	}
	
}
