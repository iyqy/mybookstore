<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    
    <title>添加图书的表单</title>
  </head>
 
  <body style="text-align: center">
    <form action="${pageContext.request.contextPath }/manager/BookServlet?method=add" method="post" enctype="multipart/form-data">
  		<table border="1" width="500px">
   				<tr>
   					<td>图书名称</td>
   					<td>
   						<input type="text" name="name" />
   					</td>
   				</tr>
   				<tr>
   					<td>作者</td>
   					<td>
   						<input type="text" name="author" />
   					</td>
   				</tr>
   				<tr>
   					<td>售价</td>
   					<td>
   						<input type="text" name="price" />
   					</td>
   				</tr>
   				<tr>
   					<td>页数</td>
   					<td>
   						<input type="text" name="pagenum" />
   					</td>
   				</tr>
   				<tr>
   					<td>图书封面</td>
   					<td>
   						<input type="file" name="imagepath" />
   					</td>
   				</tr>
   				<tr>
   					<td>图书类别</td>
   					<td>
   						<select name="categorysid">
   							<c:forEach var="category" items="${categorys }">
   								<option value="${category.id }">${category.name }</option>
   							</c:forEach>
   						</select>
   					</td>
   				</tr>
   				<tr>
   					<td colspan="2">
   						<input type="submit" value="添加图书">
   					</td>
   				</tr>
   			</table>
  	</form>
  </body>
</html>
