package cn.itcast.bookstore.web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.Address;
import cn.itcast.bookstore.domain.Order;
import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.service.BusinessService;
import cn.itcast.bookstore.utils.WebUtils;

public class ManagerOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if("listOrder".equals(method))
			listOrder(request, response);
		else if("showOrder".equals(method))
			showOrder(request, response);
		else if("send".equals(method))
			send(request, response);
	}

	private void send(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获得 ordersid
		String ordersid = request.getParameter("ordersid");
		
		BusinessService businessService = new BusinessService();
		boolean b = businessService.send(ordersid);
		
		if(b)
			response.sendRedirect(request.getContextPath() + "/manager/ManagerOrderServlet?method=listOrder&status=true");
		else
			WebUtils.forward(request, response, "发货失败");
		
	}

	// 查看指定的订单
	private void showOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获得 ordersid
		String ordersid = request.getParameter("ordersid");
		
		// 查出 订单
		BusinessService businessService = new BusinessService();
		Order order = businessService.getOrder(ordersid);
		
		// 查出订单用户
		User user = businessService.getOrderUser(order);
		
		// 查出订单地址
		Address address = businessService.getOrderAddress(order);
		
		// 查出订单列表
		List orderItems = businessService.getOrderItems(order);
		
		// 转发
		request.setAttribute("user", user);
		request.setAttribute("address", address);
		request.setAttribute("orderItems", orderItems);
		request.getRequestDispatcher("/WEB-INF/manager/order/showorder.jsp").forward(request, response);
		
	}


	// 查看所有的订单
	private void listOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获得 status
		boolean status = Boolean.parseBoolean(request.getParameter("status"));
		
		// 找 service 
		BusinessService businessService = new BusinessService();
		List orders = businessService.getAllOrders(status);
		
		// 转发
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/WEB-INF/manager/order/listorder.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
