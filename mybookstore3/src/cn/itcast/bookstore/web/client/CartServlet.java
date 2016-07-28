package cn.itcast.bookstore.web.client;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.Book;
import cn.itcast.bookstore.domain.Shoppingcart;
import cn.itcast.bookstore.domain.ShoppingcartItem;
import cn.itcast.bookstore.service.BookService;
import cn.itcast.bookstore.service.BusinessService;

public class CartServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if("buy".equals(method))
			buy(request, response);
		else if("listcart".equals(method))
			listcart(request, response);
		else if("update".equals(method))
			update(request, response);
		else if("clear".equals(method))
			clear(request, response);
		else if("delete".equals(method))
			delete(request, response);
		
	}

	// 删除条目
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 从 session 中取出购物车
		Shoppingcart cart = (Shoppingcart) request.getSession().getAttribute("cart");
		
		// 获得  id
		String bookid = request.getParameter("bookid");
		
		// 根据id 删除条目
		cart.getMap().remove(bookid);

		// 跳转至购物车页面
		response.sendRedirect(request.getContextPath() + "/client/CartServlet?method=listcart");
	}

	// 清空购物车
	private void clear(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 从 session 中取出购物车
		Shoppingcart cart = (Shoppingcart) request.getSession().getAttribute("cart");
		
		// 清空 map
		cart.getMap().clear();
		
		// 跳转至购买页面
		response.sendRedirect(request.getContextPath() + "/client/ListBookServlet");
	}

	// 修改数量
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获得id 和数量
		String bookid = request.getParameter("bookid");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		// 从 session 中取出购物车
		Shoppingcart cart = (Shoppingcart) request.getSession().getAttribute("cart");
		
		// 取出map 
		Map<String, ShoppingcartItem> map = cart.getMap();
		
		// 通过id找到条目 修改数量
		map.get(bookid).setQuantity(quantity);

		// 跳转至购物车页面
		response.sendRedirect(request.getContextPath() + "/client/CartServlet?method=listcart");
	}

	// 显示购物车商品
	private void listcart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 由于购物车在 session 中 所以直接转发
		request.getRequestDispatcher("/WEB-INF/client/listcart.jsp").forward(request, response);
	}

	// 处理购物请求
	private void buy(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获得 id
		String bookid = request.getParameter("bookid");
		// 查出对应的 book
		BookService bookService = new BookService();
		Book book = bookService.findBook(bookid);
		
		// 从 session 中取出购物车
		Shoppingcart cart = (Shoppingcart) request.getSession().getAttribute("cart");
		if(cart==null) {
			cart = new Shoppingcart();
			request.getSession().setAttribute("cart", cart);
		}
		// 找 service 购物
		BusinessService businessService = new BusinessService();
		businessService.buyBook(cart, book);
		
		// 跳转至购物车页面
		response.sendRedirect(request.getContextPath() + "/client/CartServlet?method=listcart");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
