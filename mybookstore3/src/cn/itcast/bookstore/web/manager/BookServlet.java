package cn.itcast.bookstore.web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.Book;
import cn.itcast.bookstore.service.BookService;
import cn.itcast.bookstore.service.CategoryService;
import cn.itcast.bookstore.utils.WebUtils;

public class BookServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method = request.getParameter("method");
		
		if("addUI".equals(method))
			addUI(request, response);
		else if("add".equals(method))
			add(request, response);
		else if("list".equals(method))
			list(request, response);
		else if("updateUI".equals(method))
			updateUI(request, response);
		else if("update".equals(method))
			update(request, response);
		else if("delete".equals(method))
			delete(request, response);
		
	}

	
	// 删除
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	
		// 获得 bookid
		String bookid = request.getParameter("bookid");
		
		// 找 service 做删除
		BookService bookService = new BookService();
		boolean b = bookService.deleteBook(bookid);
		
		// 显示结果
		if(b)
			WebUtils.forward(request, response, "删除图书成功");
		else
			WebUtils.forward(request, response, "删除图书失败");*/
	}


	// 处理修改图书的请求
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 表单参数封装到bean
		Book bean = WebUtils.request2Bean(request, Book.class);
		
		// 修改
		BookService bookService = new BookService();
		boolean b = bookService.updateBook(bean);
		
		// 显示结果
		if(b)
			WebUtils.forward(request, response, "修改图书成功");
		else
			WebUtils.forward(request, response, "修改图书失败");
	}

	// 发送修改图书的表单
	private void updateUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获得 bookid
		String bookid = request.getParameter("bookid");
		// 查出 book
		BookService bookService = new BookService();
		Book book = bookService.findBook(bookid);
		// 查出所有的分类
		CategoryService categoryService = new CategoryService();
		List categorys = categoryService.getAllCategorys();
		
		// 转发
		request.setAttribute("book", book);
		request.setAttribute("categorys", categorys);
		request.getRequestDispatcher("/WEB-INF/manager/book/update.jsp").forward(request, response);
	}

	// 查看所有的图书
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 找 service 查找所有的图书
		BookService bookService = new BookService();
		List books = bookService.getAllBooks();
		
		// 转发
		request.setAttribute("books", books);
		request.getRequestDispatcher("/WEB-INF/manager/book/list.jsp").forward(request, response);
	}

	// 处理添加图书的请求
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 请求参数封装到bean (做文件上传)
		Book bean = WebUtils.doUpload(request, Book.class);
		// 找 service 做添加
		BookService bookService = new BookService();
		boolean b = bookService.addBook(bean);
		// 显示结果
		if(b)
			WebUtils.forward(request, response, "添加图书成功");
		else
			WebUtils.forward(request, response, "添加图书失败");
	}

	// 发送添加图书的表单
	private void addUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 查出所有的分类
		CategoryService categoryService = new CategoryService();
		List categorys = categoryService.getAllCategorys();
		
		
		// 转发
		request.setAttribute("categorys", categorys);
		request.getRequestDispatcher("/WEB-INF/manager/book/add.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
