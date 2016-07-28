<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>显示所有的图书</title>

</head>

<body style="text-align: center;">

	<table border="1" width="700px">
		<tr>
			<td>图书名称</td>
			<td>作者</td>
			<td>售价</td>
			<td>页数</td>
			<td>封面</td>
			<td>操作</td>
		</tr>
		<c:forEach var="book" items="${books }">
			<tr>
				<%-- 判断够不够10个，不够10个，直接显示，够10个显示前面10个加。。。 --%>
				<td>${fn:substring(book.name, 0, 10)}${fn:length(book.name)>10? '...': '' }</td>
				<td>${book.author }</td>
				<td>${book.price }</td>
				<td>${book.pagenum }</td>
				<td><a
					href="${pageContext.request.contextPath }${book.imagepath }">查看图片</a>
				</td>
				<td><a
					href="${pageContext.request.contextPath }/manager/BookServlet?method=updateUI&bookid=${book.id }">修改</a>

,
					<a
					href="${pageContext.request.contextPath }/manager/BookServlet?method=delete&bookid=${book.id }">删除</a>
					<!--  <a href="#">删除</a>--></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>