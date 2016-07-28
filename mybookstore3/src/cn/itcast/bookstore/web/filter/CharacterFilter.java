package cn.itcast.bookstore.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class CharacterFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 解决 response 乱码问题
		response.setContentType("text/html;charset=utf-8");
		
		// 解决 request 乱码问题  只对post方法有效
		request.setCharacterEncoding("utf-8");
		
		// 造一个假的 request  所有的方法都是request的  唯独一个方法是假的 getParameter
		// 装饰模式 包装设计模式
		/*
		 写一个类(包装类)对某个对象(被包装对象)进行包装
		 1. 包装类需要和被包装对象实现同样的接口
		 2. 包装类需要持有一个被包装对象
		 3. 包装类在实现接口的时候对于不需要包装的方法我们通过调用被包装对象的方法来实现
		 	对于需要包装的方法我们自己实现
		 */
		MyRequest myrequest = new MyRequest(request);
		
		// 放行
		chain.doFilter(myrequest, response);
	}

}

// 写一个 request 的包装类
class MyRequest extends HttpServletRequestWrapper {

	public MyRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	// 包装 getParameter
	@Override
	public String getParameter(String name) {
		// 调用被包装对象getParameter方法获得请求参数(乱码) 解决乱码再返回
		String value = super.getParameter(name);
		if(value==null) 
			return null;
		// 获得请求方式
		String method = super.getMethod();
		if(!"get".equalsIgnoreCase(method)) {
			return value;
		}
		// 说明是get方式 有乱码
		try {
			value = new String(value.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return value;
	}
	
	
	
}
