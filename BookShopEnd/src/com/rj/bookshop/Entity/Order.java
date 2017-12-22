package com.rj.bookshop.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	private int order_id;
	private int state;
	private User user;
	private Set<OrderLine> orderlineSet = new HashSet<OrderLine>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@ManyToOne
	@JoinColumn(name = "userid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(mappedBy = "order", targetEntity = OrderLine.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public Set<OrderLine> getOrderlineSet() {
		return orderlineSet;
	}

	public void setOrderlineSet(Set<OrderLine> orderlineSet) {
		this.orderlineSet = orderlineSet;
	}

}
