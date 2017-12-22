package com.rj.bookshop.Dao;

import java.util.List;

import com.rj.bookshop.Entity.Order;

public interface OrderDao {
	public Order addOrderDao(int userid);
	public List<Order> selectOrder();
	public Order selectOrderById(int order_id);
	public boolean updateOrder(Order order);
	public void deleteAll(Order order);
}
