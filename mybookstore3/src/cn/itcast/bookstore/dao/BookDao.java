package cn.itcast.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import cn.itcast.bookstore.domain.Book;
import cn.itcast.bookstore.exception.DaoException;
import cn.itcast.bookstore.utils.JdbcUtils;

public class BookDao {


	public Book find(String id) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			
			String sql = "select * from books where id=?";
			
			Book bean = (Book) runner.query(sql, new BeanHandler(Book.class), new Object[]{id});
			
			return bean;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	public List getAll() {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			
			String sql = "select * from books";
			
			List list = (List) runner.query(sql, new BeanListHandler(Book.class));
			
			return list;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	public boolean insert(Book book) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			
			String sql = "insert into books(id,name,author,price,pagenum,imagepath,categorysid) values(?,?,?,?,?,?,?)";
			
			int num = runner.update(sql, new Object[]{
												book.getId()
												, book.getName()
												, book.getAuthor()
												, book.getPrice()
												, book.getPagenum()
												, book.getImagepath()
												, book.getCategorysid()
											});
			if(num>0)
				return true;
			return false;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	public boolean update(Book bean) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			
			String sql = "update books set name=?,author=?,price=?,pagenum=?,imagepath=?,categorysid=? where id=?";
			
			int count = runner.update(sql, new Object[]{
								  bean.getName()
								, bean.getAuthor()
								, bean.getPrice()
								, bean.getPagenum()
								, bean.getImagepath()
								, bean.getCategorysid()
								, bean.getId()
							});
			if(count>0)
				return true;
			return false;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	public boolean delete(String id) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			
			String sql = "delete from books where id=?";
			
			int count = runner.update(sql, new Object[]{id});
			if(count>0)
				return true;
			return false;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	

	// 查 总记录数
	public int getTotalRecord() {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			
			String sql = "select count(*) from books";
			
			List list = (List) runner.query(sql, new ColumnListHandler("count(*)"));
			
			long count = (Long) list.get(0);
			
			return (int) count;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	public List getPageData(int start, int len) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			
			String sql = "select * from books limit ?,?";
			
			List list = (List) runner.query(sql, new BeanListHandler(Book.class), new Object[]{start, len});
			
			return list;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	
	
}
