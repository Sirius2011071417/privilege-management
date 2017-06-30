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
	username：${user.username }<br/>
	password：${user.password }
	<br/>
	<hr/>
	当前用户拥有的权限：
	<ul>
		<c:forEach items="${user_role }" var="ur">
			<li>${ur.name }</li>
		</c:forEach>
	</ul>
	<br/>
	<hr/>
	<form action="${pageContext.request.contextPath }/AddUserRoleServlet" method="post">
		<input type="hidden" value="${user.id }" name="user_id"/>
		<c:forEach items="${roles }" var="r">
			<input type="checkbox" value="${r.id }" name="role"/>${r.name }<br/>
		</c:forEach>
		<input type="submit" value="授予角色" />
	</form>
</body>
</html>