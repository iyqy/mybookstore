package cn.itcast.bookstore.service;

import java.util.List;

import cn.itcast.bookstore.dao.BookDao;
import cn.itcast.bookstore.domain.Book;

public class BookService {
	
	private BookDao bookDao = new BookDao();
	
	public Book findBook(String bookid) {
		return bookDao.find(bookid);
	}
	
	public List getAllBooks() {
		return bookDao.getAll();
	}
	
	public boolean addBook(Book book) {
		return bookDao.insert(book);
	}
	
	public boolean updateBook(Book book) {
		return bookDao.update(book);
	}
	
	public boolean deleteBook(String bookid) {
		return bookDao.delete(bookid);
	}

	
}