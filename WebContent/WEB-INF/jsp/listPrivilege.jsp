<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><a href="${pageContext.request.contextPath }/AddPrivilegeUIServlet">添加权限</a></p>
	<table>
		<tr>
			<td>权限名</td>
			<td>描述</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${privileges }" var="privilege">
			<tr>
				<td>${privilege.name }</td>
				<td>${privilege.description }</td>
				<td><a href="${pageContext.request.contextPath }/UpdatePrivilegeUIServlet?id=${privilege.id }">修改</a><a href="${pageContext.request.contextPath }/DeletePrivilegeServlet?id=${privilege.id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>