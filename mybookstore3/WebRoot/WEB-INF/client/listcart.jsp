<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>显示购物车</title>
    <script type="text/javascript">
  	function change(id, quantity) {
  		// quantity 做验证 
  		window.location = "${pageContext.request.contextPath }/client/CartServlet?method=update&bookid="+id+"&quantity="+quantity;
  	}
  </script>
  </head>
  
  <body style="text-align: center;">
    <table border="1" width="800px">
    	<tr>
    		<td><br>书名</td>
    		<td>单价</td>
    		<td>数量</td>
    		<td>小计</td>
    		<td>操作</td>
    	</tr>
    	<%-- entry 一个键值对 键是书的id 值书对应的条目 --%>
    	<c:forEach var="entry" items="${sessionScope.cart.map }">
    		<tr>
	    		<td>${entry.value.book.name }</td>
	    		<td>${entry.value.book.price }</td>
	    		<td>
	    			<input type="text" name="quantity" value="${entry.value.quantity }"
	    					 onblur="change('${entry.key }', this.value)" 
	    					 style="width:30px;"/>
	    		
	    		</td>
	    		<td>${entry.value.price }</td>
	    		<td>
	    			<a href="${pageContext.request.contextPath }/client/CartServlet?method=delete&bookid=${entry.key }">删除</a>
	    		</td>
    		</tr>
    	</c:forEach>
    	<tr>
    		<td>
    			<a href="${pageContext.request.contextPath }/client/CartServlet?method=clear">清空购物车</a>
    		</td>
    		<td>
    			<a href="${pageContext.request.contextPath }">继续购物</a>
    		</td>
    		<td>
    			<a href="${pageContext.request.contextPath }/client/OrderServlet?method=UI">下订单</a>
    		</td>
    		<td colspan="2">
    			购物车商品价格总计： ￥ ${cart.price } 元
    		</td>
    	</tr>
    </table>
  </body>

</html>
