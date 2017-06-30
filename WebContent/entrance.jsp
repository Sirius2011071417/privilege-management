<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入口</title>
</head>
<body>
	<c:if test="${empty user }">
		<a href="${pageContext.request.contextPath }/index.jsp">登录</a>
	</c:if>
	<c:if test="${!empty user }">
		欢迎你：${user.username }<a href="${pageContext.request.contextPath }/LogoutServlet">退出</a>
	</c:if>
	<hr/>
	<a href="${pageContext.request.contextPath }/manager/AddCustomer">添加用户</a>
	<a href="${pageContext.request.contextPath }/manager/DeleteCustomer">删除用户</a>
	<a href="${pageContext.request.contextPath }/manager/UpdateCustomer">修改用户</a>
</body>
</html>