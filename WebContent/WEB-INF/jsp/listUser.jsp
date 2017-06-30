<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有用户</title>
</head>
<body>
	<p><a href="${pageContext.request.contextPath }/AddUserUIServlet">添加用户</a></p>
	<table>
		<tr>
			<td>用户名</td>
			<td>密码</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${requestScope.users }" var="user">
			<tr>
				<td>${user.username }</td>
				<td>${user.password }</td>
				<td><a href="${pageContext.request.contextPath }/UpdateUserUIServlet?id=${user.id }">修改</a><a href="${pageContext.request.contextPath }/AddUserRoleUIServlet?user_id=${user.id }">为该用户授权</a><a href="${pageContext.request.contextPath }/DeleteUserServlet?id=${user.id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>