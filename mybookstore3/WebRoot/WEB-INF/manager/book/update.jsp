<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    
    <title>修改图书的表单</title>
  </head>
 
  <body style="text-align: center">
    <form action="${pageContext.request.contextPath }/manager/BookServlet?method=update" method="post">
    	<!-- 将book本身的imagepath 发隐藏字段 -->
    	<input type="hidden" name="imagepath" value="${book.imagepath }" />
    	<!-- 将book本身的id 发隐藏字段 -->
    	<input type="hidden" name="id" value="${book.id }" />
  		<table border="1" width="500px">
   				<tr>
   					<td>图书名称</td>
   					<td>
   						<input type="text" name="name" value="${book.name }" />
   					</td>
   				</tr>
   				<tr>
   					<td>作者</td>
   					<td>
   						<input type="text" name="author" value="${book.author }" />
   					</td>
   				</tr>
   				<tr>
   					<td>售价</td>
   					<td>
   						<input type="text" name="price" value="${book.price }" />
   					</td>
   				</tr>
   				<tr>
   					<td>页数</td>
   					<td>
   						<input type="text" name="pagenum" value="${book.pagenum }" />
   					</td>
   				</tr>
   				<tr>
   					<td>图书类别</td>
   					<td>
   						<select name="categorysid">
   							<c:forEach var="category" items="${categorys }">
   								<option value="${category.id }" ${book.categorysid==category.id?'selected':'' }>${category.name }</option>
   							</c:forEach>
   						</select>
   					</td>
   				</tr>
   				<tr>
   					<td colspan="2">
   						<input type="submit" value="修改图书">
   					</td>
   				</tr>
   			</table>
  	</form>
  </body>
</html>
