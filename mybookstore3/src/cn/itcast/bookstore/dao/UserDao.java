package cn.itcast.bookstore.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.exception.DaoException;
import cn.itcast.bookstore.utils.JdbcUtils;

public class UserDao {

	public User find(String username) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from users where username=?";
			// 查询
			User user = (User) runner.query(sql, new BeanHandler(User.class), new Object[]{username});
			return user;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public boolean insert(User userBean) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into users(id,username,password,email) values(?,?,?,?)";
			// 插入
			Object[] params = new Object[]{userBean.getId(), userBean.getUsername()
								, userBean.getPassword(), userBean.getEmail()};
			int num = runner.update(sql, params);
			if(num>0)
				return true;
			return false;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}