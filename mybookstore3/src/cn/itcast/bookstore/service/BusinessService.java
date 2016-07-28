package cn.itcast.bookstore.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.itcast.bookstore.dao.AddressDao;
import cn.itcast.bookstore.dao.BookDao;
import cn.itcast.bookstore.dao.OrderDao;
import cn.itcast.bookstore.domain.Address;
import cn.itcast.bookstore.domain.Book;
import cn.itcast.bookstore.domain.Order;
import cn.itcast.bookstore.domain.OrderItem;
import cn.itcast.bookstore.domain.Page;
import cn.itcast.bookstore.domain.Shoppingcart;
import cn.itcast.bookstore.domain.ShoppingcartItem;
import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.utils.NumberUtils;

public class BusinessService {
	
	/**
	 * 分页
	 */
	public Page getPage(int pageNum) {
		// 总记录数
		BookDao bookDao = new BookDao();
		int totalRecord = bookDao.getTotalRecord();
		
		// 计算总页数 每页显示三个
		int totalPageNum = (totalRecord+2)/3;
		
		// 计算 firstPageNum  lastPageNum  显示5个页码
		int firstPageNum = pageNum - 2;
		int lastPageNum = pageNum + 2;
		if(firstPageNum<1) {
			firstPageNum = 1;
			lastPageNum = 5;
		}
		if(lastPageNum>totalPageNum) {
			lastPageNum = totalPageNum;
			firstPageNum = lastPageNum - 4;
		}
		if(totalPageNum<5) {
			firstPageNum = 1;
			lastPageNum = totalPageNum;
		}
		
		// 查询 分页数据
		int start = (pageNum-1)*3;
		int len = 3;
		List pageData = bookDao.getPageData(start, len);
		
		// 封装page
		Page page = new Page();
		page.setFirstPageNum(firstPageNum);
		page.setLastPageNum(lastPageNum);
		page.setPageData(pageData);
		page.setPageNum(pageNum);
		page.setTotalPageNum(totalPageNum);
		page.setTotalRecord(totalRecord);
		return page;
	}
	
	
	
	/**
	 * 购物
	 */
	public void buyBook(Shoppingcart cart, Book book) {

		ShoppingcartItem item = cart.getMap().get(book.getId());
		if (item == null) {
			item = new ShoppingcartItem();
			item.setBook(book);
			item.setQuantity(1);
			cart.getMap().put(book.getId(), item);
		} else {
			item.setQuantity(item.getQuantity() + 1);
		}

	}
	
	/**
	 * 订单
	 */
	private AddressDao addressDao = new AddressDao();
	// 根据用户查找地址
	public List getUserAddress(User user) {
		return addressDao.findUserAddress(user);
	}
	
	// 添加新地址
	public boolean addAddress(Address bean) {
		return addressDao.insert(bean);
	}



	public boolean deleteAddress(String addressid) {
		
		return addressDao.delete(addressid);
	}
	
	private OrderDao orderDao = new OrderDao();
	// 生成订单
	public boolean makeOrder(Shoppingcart cart, User user, String addressid) {
		
		// 添加一条 订单记录 到数据库
		Order order = new Order();
		order.setId(UUID.randomUUID().toString());
		order.setNumber(NumberUtils.makeNumber());
		order.setOrdertime(new Date());
		order.setPrice(cart.getPrice());
		order.setStatus(false);
		order.setUsersid(user.getId());
		order.setAddressid(addressid);
		
		
		boolean b = orderDao.insert(order);
		
		if(!b)
			return false;
		
		// 为订单添加订单项
		// 一个购物车项就对应一个订单项
		// 遍历购物车项
		Collection<ShoppingcartItem> cartItems = cart.getMap().values();
		for(ShoppingcartItem cartItem : cartItems) {
			// 封装一个 OrderItem
			OrderItem orderItem = new OrderItem();
			orderItem.setId(UUID.randomUUID().toString());
			orderItem.setQuantity(cartItem.getQuantity());
			orderItem.setPrice(cartItem.getPrice());
			orderItem.setBooksid(cartItem.getBook().getId());
			orderItem.setOrdersid(order.getId());
			// 添加到数据库
			b = orderDao.addOrderItem(orderItem);
			if(!b)
				return false;
		}
		
		return true;
		
	}


	// 查找用户所有的订单
	public List getUserOrders(User user) {
		// TODO Auto-generated method stub
		return orderDao.getUserOrders(user);
	}



	public Order getOrder(String ordersid) {
		// TODO Auto-generated method stub
		return orderDao.find(ordersid);
	}


	
	public List getOrderItems(Order order) {
		List<OrderItem> orderItems = orderDao.getOrderItems(order);

		
		
		// 遍历集合  根据每个OrderItem 的 booksid 查出book 进行封装
		BookDao bookDao = new BookDao();
		for(OrderItem item : orderItems) {
			String booksid = item.getBooksid();
			Book book = bookDao.find(booksid);
			item.setBook(book);
		}
		return orderItems;
	}



	public Address getOrderAddress(Order order) {
		// TODO Auto-generated method stub
		return orderDao.getOrderAddress(order);
	}



	public List getAllOrders(boolean status) {
		// TODO Auto-generated method stub
		return orderDao.getAllOrders(status);
	}



	public User getOrderUser(Order order) {
		// TODO Auto-generated method stub
		return orderDao.getOrderUser(order);
	}



	public boolean send(String ordersid) {
		return orderDao.send(ordersid);
	}


}
