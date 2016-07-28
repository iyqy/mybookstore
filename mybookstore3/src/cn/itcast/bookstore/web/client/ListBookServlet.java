package cn.itcast.bookstore.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.Page;
import cn.itcast.bookstore.service.BusinessService;

public class ListBookServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得 pageNum
		int pageNum = 1;
		String pageNumValue = request.getParameter("pageNum");
		if(pageNumValue!=null)
			pageNum = Integer.parseInt(pageNumValue);
		// 找 service 查出所有的图书
		BusinessService businessService = new BusinessService();
		Page page = businessService.getPage(pageNum);
		
		// 转发
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/client/listbook.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
