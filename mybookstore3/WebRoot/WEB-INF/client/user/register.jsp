<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>用户注册页面</title>
  
  </head>
  <body style="text-align: center;">
    <form id="myform" action="${pageContext.request.contextPath }/client/UserServlet?method=register" method="post" >
    	<table border="1" width="50%">
    		<tr>
    			<td>用户名</td>
    			<td>
    				<input type="text" name="username" value="${formBean.username }" style="width: 150px;">
    				${formBean.errors.username } ${errorMsg }
    			</td>
    		</tr>
    		<tr>
    			<td>密码</td>
    			<td>
    				<input type="password" name="password" style="width: 150px;">${formBean.errors.password }
    			</td>
    		</tr>
    		<tr>
    			<td>确认密码</td>
    			<td>
    				<input type="password" name="password2" style="width: 150px;">${formBean.errors.password2 }
    			</td>
    		</tr>
    		<tr>
    			<td>电子邮件</td>
    			<td>
    				<input type="text" name="email" value="${formBean.email }" style="width: 150px;">${formBean.errors.email }
    		
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="reset" value="重置">
    			</td>
    			<td>
    				<input type="submit" value="注册新用户">
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
