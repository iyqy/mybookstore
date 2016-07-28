package cn.itcast.bookstore.web.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.Address;
import cn.itcast.bookstore.domain.Order;
import cn.itcast.bookstore.domain.Shoppingcart;
import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.service.BusinessService;
import cn.itcast.bookstore.utils.WebUtils;

public class OrderServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method = request.getParameter("method");
		
		if("UI".equals(method))
			UI(request, response);
		else if("addAddressUI".equals(method))
			addAddressUI(request, response);
		else if("addAddress".equals(method))
			addAddress(request, response);
		else if("deleteAddress".equals(method))
			deleteAddress(request, response);
		else if("makeOrder".equals(method))
			makeOrder(request, response);
		else if("listOrder".equals(method))
			listOrder(request, response);
		else if("showOrder".equals(method))
			showOrder(request, response);
	}

	// 查看订单的详细信息
	private void showOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获得 orderid
		String ordersid = request.getParameter("ordersid");
		
		// 查出订单
		BusinessService businessService = new BusinessService();
		Order order = businessService.getOrder(ordersid);
		
		// 根据订单查出订单项
		List orderItems = businessService.getOrderItems(order);
		
		// 根据订单查出地址
		Address address = businessService.getOrderAddress(order);
		
		// 转发
		request.setAttribute("orderItems", orderItems);
		request.setAttribute("address", address);
		request.getRequestDispatcher("/WEB-INF/client/order/showorder.jsp").forward(request, response);
	}

	// 查看当前用户所有的订单
	private void listOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获得 user
		User user = (User) request.getSession().getAttribute("user");
		
		// 找 service
		BusinessService businessService = new BusinessService();
		List userOrders = businessService.getUserOrders(user);
		
		// 转发
		request.setAttribute("userOrders", userOrders);
		request.getRequestDispatcher("/WEB-INF/client/order/listorder.jsp").forward(request, response);
	}

	// 生成订单
	private void makeOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获得 addressid
		String addressid = request.getParameter("addressid");
		// 获得 user
		User user = (User) request.getSession().getAttribute("user");
		// 获得 cart
		Shoppingcart cart = (Shoppingcart) request.getSession().getAttribute("cart");
		// 找service 生成订单
		BusinessService businessService = new BusinessService();
		boolean b = businessService.makeOrder(cart, user, addressid);
		
		if(b)
			WebUtils.forward(request, response, "订单已生成");
		else
			WebUtils.forward(request, response, "下订单失败");
	}

	private void deleteAddress(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String addressid = request.getParameter("addressid");
		
		BusinessService businessService = new BusinessService();
		boolean b = businessService.deleteAddress(addressid);
		
		if(b)
			response.sendRedirect(request.getContextPath() + "/client/OrderServlet?method=UI");
		else
			WebUtils.forward(request, response, "无法删除");
	}

	// 发送添加地址的表单
	private void addAddressUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/client/order/addAddress.jsp").forward(request, response);
	}

	// 添加地址
	private void addAddress(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// 表单参数封装到 bean
		Address bean = WebUtils.request2Bean(request, Address.class);
		
		// 找 service 最添加
		BusinessService businessService = new BusinessService();
		boolean b = businessService.addAddress(bean);
		
		if(b)
			response.sendRedirect(request.getContextPath() + "/client/OrderServlet?method=UI");
		else
			WebUtils.forward(request, response, "添加地址失败");
	}

	// 选择地址的界面
	private void UI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 查出用户对应的地址  找 service
		User user = (User) request.getSession().getAttribute("user");
		BusinessService businessService = new BusinessService();
		List userAddress = businessService.getUserAddress(user);
		// 转发 
		request.setAttribute("userAddress", userAddress);
		request.getRequestDispatcher("/WEB-INF/client/order/selectaddress.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
