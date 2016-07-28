package cn.itcast.bookstore.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 判断用户是否登录
		if(request.getSession(false)==null || request.getSession().getAttribute("user")==null) {
			// 未登陆  跳转至登录页面
			response.sendRedirect(request.getContextPath() + "/client/UserServlet?method=loginUI");
			return;
		}
		
		// 登陆  放行
		chain.doFilter(request, response);

	}

}
