<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>所有的分类</title>
    <script type="text/javascript">
    	function del(categoryid) {
    		window.location = "${pageContext.request.contextPath}/manager/CategoryServlet?method=delete&categoryid=" + categoryid;
    	}
    	
    	function update(btn, categoryid) {
    		// 删除 修改按钮
    		var tdObj = btn.parentNode;
    		tdObj.removeChild(btn);
    		
    		// 添加 input btn
    		var input = document.createElement("input");
    		input.type = "text";
    		
    		var newBtn = document.createElement("input");
    		newBtn.type = "button";
    		newBtn.value = "提交修改";
    		
    		tdObj.appendChild(input);
    		tdObj.appendChild(newBtn);
    		
    		// 为提交按钮添加点击事件
    		newBtn.onclick = function() {
    			var value = input.value;
    			// 使用 post 方式做提交
    			var form = document.createElement("form");
    			form.method = "post";
    			form.action = "${pageContext.request.contextPath}/manager/CategoryServlet?method=update";
    			var nameInput = document.createElement("input");
    			nameInput.type = "hidden";
    			nameInput.name = "name";
    			nameInput.value = value;
    			
    			var idInput = document.createElement("input");
    			idInput.type = "hidden";
    			idInput.name = "id";
    			idInput.value = categoryid;
    			
    			form.appendChild(nameInput);
    			form.appendChild(idInput);
    			
    			document.body.appendChild(form);
    			form.submit();
    		}
    	}
    </script>
  </head>
  
  <body>
   	<table width="600px" border="1">
		<tr>
			<td width="30%">分类名称</td>
			<td colspan="2">操作</td>
		</tr> 
		<c:forEach var="category" items="${categorys}">//????
		<tr>
			<td>${category.name }</td>
			<td>
				<input type="button" value="修改" onclick="update(this,'${category.id }')"/>
			</td>
			<td>
				<input type="button" value="删除" onclick="del('${category.id }')"/>
			</td>
		</tr> 	
		</c:forEach>  		
   	</table>
  </body>
</html>
