<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>left</title>
</head>
<body>
	<p><a href="${pageContext.request.contextPath }/listUserServlet" target="main">用户管理</a></p>
	<p><a href="${pageContext.request.contextPath }/listRoleServlet" target="main">角色管理</a></p>
	<p><a href="${pageContext.request.contextPath }/listPrivilegeServlet" target="main">权限管理</a></p>
</body>
</html>