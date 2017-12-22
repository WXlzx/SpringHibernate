package com.rj.bookshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rj.bookshop.Dao.BookDao;
import com.rj.bookshop.Entity.Book;

@Service
@Transactional
public class BookService {
	@Autowired
	private BookDao bookDao;

	public List<Book> selectBook() {
		return bookDao.select();
	}

	public boolean insertBook(Book book) {
		return bookDao.insert(book);
	}
	
	public boolean updateBook(Book book) {
		return bookDao.update(book);
	}

	public boolean deleteBook(Book book) {
		return bookDao.delete(book);
	}

	public Book selectBookById(int id) {
		return bookDao.selectById(id);
	}
	
	public List<Book> likeSelect(String name){
		return bookDao.likeSelect(name);
	}
}
