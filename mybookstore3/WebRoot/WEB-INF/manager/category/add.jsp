<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    
    <title>添加分类</title>
  </head>
 
  <body style="text-align: center">
    <form action="${pageContext.request.contextPath }/manager/CategoryServlet?method=add" method="post"> 
    	<br><br>分类名称 : <input type="text" name="name" /><br>
    	
    	<input type="submit" value="添加分类" />
    </form>
  </body>
</html>
