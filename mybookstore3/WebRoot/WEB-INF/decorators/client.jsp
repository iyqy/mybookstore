<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title><decorator:title default="Welcome!" /></title>
    <decorator:head />
  </head>
  
  <body style="text-align: center;">
    <div style="width:1002px; height: 800px;">
    <br>
  	<h3>网 上 书 城</h3>
	<div style="text-align: left;">
	<c:choose>
		<c:when test="${sessionScope.user==null }">
		您还未登陆，请选择
		<a href="${pageContext.request.contextPath }/client/UserServlet?method=loginUI">用户登陆</a>或
  	    <a href="${pageContext.request.contextPath }/client/UserServlet?method=registerUI">注册新用户</a>
		</c:when>
		<c:otherwise>
			欢迎你！${sessionScope.user.username }
			<a href="${pageContext.request.contextPath }/client/UserServlet?method=logout">退出</a>
		</c:otherwise>
	</c:choose>
  	
  	 </div>
  	 <div style="text-align: right;">
  	<a href="${pageContext.request.contextPath }/client/ListBookServlet">回到首页</a>
  	<a href="${pageContext.request.contextPath }/client/CartServlet?method=listcart">查看购物车</a>
  	<a href="${pageContext.request.contextPath }/client/OrderServlet?method=listOrder">查看所有的订单</a>
  	<c:if test="${sessionScope.user.username=='manager' }">
	
	</c:if>
	<a href="${pageContext.request.contextPath }/manager/ManagerIndexServlet">进入后台管理</a>
  	</div>
     <hr>
   	
   	<decorator:body></decorator:body> 
   
    </div>
    
   
  </body>
</html>
