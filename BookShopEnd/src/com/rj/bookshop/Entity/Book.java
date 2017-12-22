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

@Entity
public class Book {
	private int book_id;
	private String book_name;
	private double book_price;
	private String book_describe;
	private String book_author;
	private String book_img;
	private Kind kind;
	private Set<OrderLine> orderlineSet = new HashSet<OrderLine>();
	
	
	public Book(){
		
	}
	
	public Book(String book_name, double book_price, String book_describe, String book_author, String book_img) {
		super();
		this.book_name = book_name;
		this.book_price = book_price;
		this.book_describe = book_describe;
		this.book_author = book_author;
		this.book_img = book_img;
	}
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public double getBook_price() {
		return book_price;
	}

	public void setBook_price(double book_price) {
		this.book_price = book_price;
	}

	public String getBook_describe() {
		return book_describe;
	}

	public void setBook_describe(String book_describe) {
		this.book_describe = book_describe;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_img() {
		return book_img;
	}

	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}

	@ManyToOne
	@JoinColumn(name = "kind_id")
	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	@OneToMany(mappedBy = "book", targetEntity = OrderLine.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public Set<OrderLine> getOrderlineSet() {
		return orderlineSet;
	}

	public void setOrderlineSet(Set<OrderLine> orderlineSet) {
		this.orderlineSet = orderlineSet;
	}

}
