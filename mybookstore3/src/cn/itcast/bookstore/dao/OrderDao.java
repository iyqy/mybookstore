package cn.itcast.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.bookstore.domain.Address;
import cn.itcast.bookstore.domain.Order;
import cn.itcast.bookstore.domain.OrderItem;
import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.exception.DaoException;
import cn.itcast.bookstore.utils.JdbcUtils;

public class OrderDao {


	public boolean insert(Order order) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

			String sql = "insert into orders(id,number,ordertime,price,status,usersid,addressid) values(?,?,?,?,?,?,?)";

			int count = runner.update(
					sql,
					new Object[] { order.getId(), order.getNumber(),
							order.getOrdertime(), order.getPrice(),
							order.isStatus(), order.getUsersid(),
							order.getAddressid() });
			if (count > 0)
				return true;
			return false;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}


	public boolean addOrderItem(OrderItem orderItem) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

			String sql = "insert into orderitems(id,quantity,price,ordersid,booksid) values(?,?,?,?,?)";

			int count = runner.update(sql,
					new Object[] { orderItem.getId(), orderItem.getQuantity(),
							orderItem.getPrice(), orderItem.getOrdersid(),
							orderItem.getBooksid() });
			if (count > 0)
				return true;
			return false;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public List getUserOrders(User user) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

			String sql = "select * from orders where usersid=?";

			List list = (List) runner.query(sql, new BeanListHandler(
					Order.class), new Object[] { user.getId() });

			return list;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public Order find(String ordersid) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

			String sql = "select * from orders where id=?";

			Order order = (Order) runner.query(sql,
					new BeanHandler(Order.class), new Object[] { ordersid });

			return order;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}


	public List getOrderItems(Order order) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

			String sql = "select * from orderitems where ordersid=?";

			List list = (List) runner.query(sql, new BeanListHandler(
					OrderItem.class), new Object[] { order.getId() });

			return list;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}


	public Address getOrderAddress(Order order) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

			String sql = "select * from address where id=?";

			Address address = (Address) runner.query(sql, new BeanHandler(
					Address.class), new Object[] { order.getAddressid() });

			return address;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}


	public List getAllOrders(boolean status) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

			String sql = "select * from orders where status=?";

			List list = (List) runner.query(sql, new BeanListHandler(
					Order.class), new Object[] { status });

			return list;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}


	public User getOrderUser(Order order) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

			String sql = "select * from users where id=?";

			User user = (User) runner.query(sql, new BeanHandler(User.class),
					new Object[] { order.getUsersid() });

			return user;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public boolean send(String ordersid) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

			String sql = "update orders set status=true where id=?";

			int count = runner.update(sql, ordersid);
			if (count > 0)
				return true;
			return false;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
