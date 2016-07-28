<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>选择地址界面</title>
    
  </head>
  
  <body>
  <div style="width: 400px; text-align: left;">
    请选择一个地址
    <a href="${pageContext.request.contextPath }/client/OrderServlet?method=addAddressUI">添加一个新地址</a>
    <br>
    <form action="${pageContext.request.contextPath }/client/OrderServlet?method=makeOrder" method="post">
    <c:forEach var="address" items="${userAddress }">
    	<input type="radio" name="addressid" value="${address.id }" />${address.name }/${address.location }/${address.cellphone }
    	<a href="${pageContext.request.contextPath }/client/OrderServlet?method=deleteAddress&addressid=${address.id }">删除</a>
    	<br>
    </c:forEach>
    <input type="submit" value="生成订单" />
    </form>
    </div>
  </body>
</html>
