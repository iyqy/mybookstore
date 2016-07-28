<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>用户所有的订单</title>
    <script type="text/javascript">
    	function send(ordersid) {
    		window.location = "${pageContext.request.contextPath }/manager/ManagerOrderServlet?method=send&ordersid=" + ordersid;
    	}
    </script>
  </head>
  
  <body>
    <table border="1" width="600px">
    	<tr>
    		<td>订单编号</td>
    		<td>订单时间</td>
    		<td>订单价格</td>
    		<td>订单状态</td>
    		<td>查看订单</td>
    		<td>点击发货</td>
    	</tr>
    	<c:forEach var="order" items="${orders }">
    	<tr>
    		<td>${order.number }</td>
    		<td>${order.ordertime }</td>
    		<td>${order.price }</td>
    		<td>${order.status?'已发货':'未发货' }</td>
    		<td>
    			<a href="${pageContext.request.contextPath }/manager/ManagerOrderServlet?method=showOrder&ordersid=${order.id }">点击查看</a>
    		</td>
    		<td>
    			
    			<input type="button" value="发货" onclick="send('${order.id }')" ${order.status?'disabled':'' } />
    		</td>
    	</tr>	
    	</c:forEach>
    </table>
  </body>
</html>
