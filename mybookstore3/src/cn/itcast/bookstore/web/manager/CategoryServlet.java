package cn.itcast.bookstore.web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.Category;
import cn.itcast.bookstore.service.CategoryService;
import cn.itcast.bookstore.utils.WebUtils;

public class CategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 判断 method  知道用户的动作(action)
		String method = request.getParameter("method");
		if("addUI".equals(method)) 
			addUI(request, response);
		else if("list".equals(method))
			list(request, response);
		else if("add".equals(method))
			add(request, response);
		else if("delete".equals(method))
			delete(request, response);
		else if("update".equals(method))
			update(request, response);
	}

	// 修改分类
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 表单参数封装到bean
		Category bean = WebUtils.request2Bean(request, Category.class);
		
		// 找 service 做修改
		CategoryService categoryService = new CategoryService();
		boolean b = categoryService.updateCategory(bean);
		
		// 显示结果
		if(b) 
			WebUtils.forward(request, response, "修改分类成功");
		else 
			WebUtils.forward(request, response, "修改分类失败");

	}

	// 删除分类
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获得分类id
		String categoryid = request.getParameter("categoryid");
		
		// 找 service 做删除
		CategoryService categoryService = new CategoryService();
		boolean b = categoryService.deleteCategory(categoryid);
		
		// 显示结果
		if(b) 
			WebUtils.forward(request, response, "删除分类成功");
		else 
			WebUtils.forward(request, response, "删除分类失败");

	}

	// 处理添加分类的请求
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 表单参数封装到bean
		Category bean = WebUtils.request2Bean(request, Category.class);
		
		// 找 service 做添加
		CategoryService categoryService = new CategoryService();
		boolean b = categoryService.addCategory(bean);
		
		// 显示结果
		if(b) {
			// 添加成功
			WebUtils.forward(request, response, "添加分类成功");
		}else {
			// 添加失败
			WebUtils.forward(request, response, "添加分类失败");
		}
	}

	// 查看所有的分类
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 找service 查找所有的分类
		CategoryService categoryService = new CategoryService();
		List categorys = categoryService.getAllCategorys();
		
		// 转发
		request.setAttribute("categorys", categorys);
		request.getRequestDispatcher("/WEB-INF/manager/category/list.jsp").forward(request, response);
	}

	// 发送 添加分类的表单
	private void addUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/manager/category/add.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
