package com.rj.bookshop.Dao;

import java.util.List;
import com.rj.bookshop.Entity.Book;

public interface BookDao {
	public List<Book> select();
	public boolean insert(Book book);
	public boolean update(Book book);
	public boolean delete(Book book);
	public Book selectById(int id);
	public List<Book> likeSelect(String name);
}
