package com.rj.bookshop.Dao;

import com.rj.bookshop.Entity.Order;
import com.rj.bookshop.Entity.OrderLine;

public interface OrderLineDao {
	public void addOrderLineDao(int bookid,Order order,int count);
	public boolean updateOrderLine(OrderLine orderline);
	public boolean deleteOrderLine(OrderLine orderline);
	public OrderLine selectOrderLineById(int orderline_id);
}
