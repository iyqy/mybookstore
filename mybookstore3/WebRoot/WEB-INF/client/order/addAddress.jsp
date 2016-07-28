<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加地址界面</title>
</head>
<body>
	<form
		action="${pageContext.request.contextPath }/client/OrderServlet?method=addAddress"
		method="post">
		<input type="hidden" name="usersid" value="${sessionScope.user.id }" />
		<table border="1" width="500px">
			<table>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>电话</td>
					<td><input type="text" name="cellphone" /></td>
				</tr>
				<tr>
					<td>地址</td>
					<td><input type="text" name="location" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="添加地址"></td>
				</tr>
			</table>
			</form>
</body>
</html>