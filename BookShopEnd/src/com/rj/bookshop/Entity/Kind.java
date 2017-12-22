package com.rj.bookshop.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kind {
	private int kind_id;
	private String kind_name;
	private Set<Book> bookSet = new HashSet<Book>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getKind_id() {
		return kind_id;
	}

	public void setKind_id(int kind_id) {
		this.kind_id = kind_id;
	}

	public String getKind_name() {
		return kind_name;
	}

	public void setKind_name(String kind_name) {
		this.kind_name = kind_name;
	}
	
	@OneToMany(mappedBy = "kind", targetEntity = Book.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	public Set<Book> getBookSet() {
		return bookSet;
	}

	public void setBookSet(Set<Book> bookSet) {
		this.bookSet = bookSet;
	}

}
