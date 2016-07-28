<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>首页</title>
<script type="text/javascript">
	function buy(bookid) {
		window.location = "${pageContext.request.contextPath }/client/CartServlet?method=buy&bookid="
				+ bookid;
	}
</script>
</head>

<body style="text-align: center;">
	<div style="width: 800px; height: 800px;">
		<div name="left"
			style="width: 300px; height: 800px; float: left; padding-top: 40px;">
			<form action="">
				分类:<select>
					<option></option>
				</select> 作者:<input type="text" name="author" />
			</form>
		</div>
		<div name="right" style="width: 480px; height: 800px; float: left;">
			<!-- 显示所有的图书 -->
			<c:forEach var="book" items="${page.pageData }">
				<div style="width: 400px; height: 200px; float: left;">
					<div style="width: 85px; height: 115px; float: left;">
						<img width="85" height="115"
							src="${pageContext.request.contextPath }${book.imagepath }">
					</div>
					<div
						style="width: 200px; height: 115px; float: left; margin-left: 20px; text-align: left;">
						<br> 书名 ： ${fn:escapeXml(book.name) }<br> 作者 ：
						${fn:escapeXml(book.author) }<br> 售价 ：
						${fn:escapeXml(book.price) }<br> 页数 ：
						${fn:escapeXml(book.pagenum) }<br> <input type="button"
							value="购买" onclick="buy('${book.id}')" /><br>
					</div>
				</div>
			</c:forEach>
			<span style="clear: left;"></span>
			<div style="text-align: left;">
				当前第 ${page.pageNum } 页
				<c:if test="${page.pageNum>1 }">
					<a
						href="${pageContext.request.contextPath }/client/ListBookServlet?pageNum=${page.pageNum-1}">上一页</a>
				</c:if>
				<c:forEach var="num" begin="${page.firstPageNum }"
					end="${page.lastPageNum }">
					<c:choose>
						<c:when test="${num==page.pageNum }">
   							[ ${num } ]
   						</c:when>
						<c:otherwise>
   						[ <a
								href='${pageContext.request.contextPath }/client/ListBookServlet?pageNum=${num}'>${num }</a> ]
   						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${page.pageNum<page.totalPageNum }">
					<a
						href="${pageContext.request.contextPath }/client/ListBookServlet?pageNum=${page.pageNum+1}">下一页</a>
				</c:if>
				<br> 总共 ${page.totalPageNum } 页 总共 ${page.totalRecord } 条记录
			</div>
		</div>


	</div>
</body>
</html>
