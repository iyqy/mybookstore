package cn.itcast.bookstore.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.bookstore.exception.DaoException;
import cn.itcast.bookstore.utils.JdbcUtils;

public class RunDao {

	public RunDao() {

	}

	public <T> T getResult(T t, String sql, Class c, Object obj) {
		QueryRunner run = new QueryRunner(JdbcUtils.getDataSource());
		try {
			if (t instanceof Boolean) {
				int num = (Integer) run.query(sql, obj, new BeanListHandler(c));
				if (num > 0)
					return t;
				return (T) change(false);
			} else {
				t = (T) run.query(sql, obj, new BeanListHandler(c));
				return t;
			}
		} catch (SQLException e) {
			throw new DaoException();
		}

	}

	public <T> T change(T t) {
		return t;
	}
}
