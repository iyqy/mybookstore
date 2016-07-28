<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>显示订单详细信息</title>
    
  </head>
  
  <body>
    订单详细信息如下 <br>
    <table border="1" width="500px">
    	<tr>
    		<th colspan="2">订单用户</th>
    	</tr>
    	<tr>
    		<td>用户名</td>
    		<td>${user.username }</td>
    	</tr>
    	<tr>
    		<td>电子邮件</td>
    		<td>${user.email }</td>
    	</tr>
    </table>
    <table border="1" width="500px">
    	<tr>
    		<th colspan="2">收货人信息</th>
    	</tr>
    	<tr>
    		<td>收货人姓名</td>
    		<td>${address.name }</td>
    	</tr>
    	<tr>
    		<td>收货人地址</td>
    		<td>${address.location }</td>
    	</tr>
    	<tr>
    		<td>收货人电话</td>
    		<td>${address.cellphone }</td>
    	</tr>
    </table>
    <table border="1" width="500px">
    	<tr>
    		<th colspan="3">订单商品列表</th>
    	</tr>
    	<tr>
    		<td>商品</td>
    		<td>购买数量</td>
    		<td>小计</td>
    	</tr>
    	<c:forEach var="orderItem" items="${orderItems }">
    	<tr>
    		<td>${orderItem.book.name }</td>
    		<td>${orderItem.quantity }</td>
    		<td>${orderItem.price }</td>
    	</tr>	
    	</c:forEach>
    </table>
  </body>
</html>
