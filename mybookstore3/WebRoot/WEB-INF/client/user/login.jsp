<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>用户登陆页面</title>
  
  </head>
  
  <body style="text-align: center;">
  ${message }<br>
    <form action="${pageContext.request.contextPath }/client/UserServlet?method=login" method="post">
    ${errorMsg }<a href="${pageContext.request.contextPath }/client/UserServlet?method=registerUI">注册新用户</a>
    	<table border="1" width="40%">
    		<tr>
    			<td>用户名</td>
    			<td>
    				<input type="text" name="username" value="${username }">
    			</td>
    		</tr>
    		<tr>
    			<td>密码</td>
    			<td>
    				<input type="password" name="password">
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="reset" value="重置">
    			</td>
    			<td>
    				<input type="submit" value="用户登陆">
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
