package cn.itcast.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.bookstore.domain.Address;
import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.exception.DaoException;
import cn.itcast.bookstore.utils.JdbcUtils;

public class AddressDao {
	RunDao dao = new RunDao();

	// 根据用户查出所有地址
	public List findUserAddress(User user) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

			String sql = "select * from address where usersid=?";

			List list = (List) runner.query(sql, new BeanListHandler(
					Address.class), new Object[] { user.getId() });

			return list;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	// 添加一个新地址
	public boolean insert(Address bean) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

			String sql = "insert into address(id,name,location,cellphone,usersid) values(?,?,?,?,?)";

	

			int num = runner.update(
					sql,
					new Object[] { bean.getId(), bean.getName(),
							bean.getLocation(), bean.getCellphone(),
							bean.getUsersid() });
			if (num > 0)
				return true;
			return false;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public boolean delete(String addressid) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

			String sql = "delete from address where id=?";

			int num = runner.update(sql, addressid);
			if (num > 0)
				return true;
			return false;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
