package cn.itcast.bookstore.web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bookstore.domain.User;
import cn.itcast.bookstore.service.UserService;
import cn.itcast.bookstore.utils.WebUtils;
import cn.itcast.mybookstore.formbean.RegisterFormBean;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// loginUI login registerUI register logout
		String method = request.getParameter("method");
		if ("registerUI".equals(method))
			request.getRequestDispatcher("/WEB-INF/client/user/register.jsp")
					.forward(request, response);
		else if ("register".equals(method))
			register(request, response);
		else if ("loginUI".equals(method))
			request.getRequestDispatcher("/WEB-INF/client/user/login.jsp")
					.forward(request, response);
		else if ("login".equals(method))
			login(request, response);
		else if ("logout".equals(method))
			logout(request, response);

	}

	// 处理注册
	private void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 表单参数到formbean
		RegisterFormBean formBean = WebUtils.request2Bean(request,
				RegisterFormBean.class);

		// 验证
		boolean b = formBean.validate();
		if (!b) {
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/WEB-INF/client/user/register.jsp")
					.forward(request, response);
			return;
		}

		// 将 formbean的数据导入userbean
		User userBean = new User();
		WebUtils.copyBean(formBean, userBean);
		
		// 找service 做注册
		UserService userService = new UserService();
		b = userService.registerUser(userBean);
		
		if (b) {
			
			request.getSession().setAttribute("user", userBean);
			response.sendRedirect(request.getContextPath()
					+ "/client/ListBookServlet");
		} else {
			
			request.setAttribute("formBean", formBean);
			request.setAttribute("errorMsg", userService.getRegisterError());
			request.getRequestDispatcher("/WEB-INF/client/user/register.jsp")
					.forward(request, response);

		}

	}

	// 登出
	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		request.getSession().removeAttribute("user");
		response.sendRedirect(request.getContextPath());
	}

	// 处理登陆请求
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 找 service
		UserService service = new UserService();
		User user = service.loginUser(username, password);

		if (user == null) {
			request.setAttribute("errorMsg", service.getLoginError());
			request.getRequestDispatcher("/WEB-INF/client/user/login.jsp")
					.forward(request, response);
		} else {
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()
					+ "/client/ListBookServlet");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
