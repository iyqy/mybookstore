<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<decorator:title default="Welcome!" />
<title></title>
<decorator:head />
</head>

<body style="text-align: center;">
	<div style="width: 1002px; height: 703px; margin: 0px auto;">
		<div name="top"
			style="width: 1000px; height: 100px; border: 1px solid #00000; padding-top: 40px; ">
			<h3> 书 店 后 台 管 理</h3>
		</div>
		<div name="left"
			style="width: 199px; height: 600px; border: 1px solid #00000; float: left; padding-top: 80px; ">
			分类管理<br> <a
				href="${pageContext.request.contextPath }/manager/CategoryServlet?method=addUI">添加分类</a><br>
			<a
				href="${pageContext.request.contextPath }/manager/CategoryServlet?method=list">查看分类</a><br>
			<br> 图书管理<br> <a
				href="${pageContext.request.contextPath }/manager/BookServlet?method=addUI">添加图书</a><br>
			<a
				href="${pageContext.request.contextPath }/manager/BookServlet?method=list">查看图书</a><br>
			<br> 订单管理<br> <a
				href="${pageContext.request.contextPath }/manager/ManagerOrderServlet?method=listOrder&status=true">已发货订单管理</a><br>
			<a
				href="${pageContext.request.contextPath }/manager/ManagerOrderServlet?method=listOrder&status=false">未发货订单管理</a><br>
			<br>
		</div>
		<div name="center"
			style="width: 800px; height: 600px; border: 1px solid #00000; float: left; padding-top: 100px; ">
			<decorator:body />
		</div>
	</div>
</body>
</html>
