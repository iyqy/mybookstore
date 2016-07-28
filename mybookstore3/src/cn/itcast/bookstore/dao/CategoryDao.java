package cn.itcast.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.bookstore.domain.Category;
import cn.itcast.bookstore.exception.DaoException;
import cn.itcast.bookstore.utils.JdbcUtils;

public class CategoryDao {
	
	// 查找分类
	public Category find(String id) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			
			String sql = "select * from categorys where id=?";
			
			Category bean = (Category) runner.query(sql, new BeanHandler(Category.class), new Object[]{id});
			
			return bean;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	//  查找所有的分类
	public List getAll() {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			
			String sql = "select * from categorys";
			
			List list = (List) runner.query(sql, new BeanListHandler(Category.class));
			
			return list;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	// 添加分类
	public boolean insert(Category bean) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			
			String sql = "insert into categorys(id,name) values(?,?)";
			
			int count = runner.update(sql, new Object[]{
								bean.getId()
								, bean.getName()
							});
			if(count>0)
				return true;
			return false;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	// 修改分类
	public boolean update(Category bean) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			
			String sql = "update categorys set name=? where id=?";
			
			int count = runner.update(sql, new Object[]{
								bean.getName()
								, bean.getId()
							});
			if(count>0)
				return true;
			return false;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	// 删除分类
	public boolean delete(String id) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			
			String sql = "delete from categorys where id=?";
			
			int count = runner.update(sql, new Object[]{id});
			if(count>0)
				return true;
			return false;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
}
