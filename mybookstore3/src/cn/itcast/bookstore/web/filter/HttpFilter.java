package cn.itcast.bookstore.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 模板方法设计模式
public abstract class HttpFilter implements Filter {
	
	private FilterConfig filterConfig;

	public final void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// 强转
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		// 调用自己重载的 doFilter
		this.doFilter(request, response, chain);
	}
	
	public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
	 throws IOException, ServletException ;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		init();
	}
	
	public void init(){} ;

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
	
	

}
