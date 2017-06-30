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
	当前角色名称：${role.name }<br/>
	当前角色描述：${role.description }
	<br/>
	<hr/>
	当前角色拥有的权限：
	<ul>
		<c:forEach items="${role_privilege }" var="rp">
			<li>${rp.name }</li>
		</c:forEach>
	</ul>
	<br/>
	<hr/>
	<form action="${pageContext.request.contextPath }/AddRolePrivilegeServlet" method="post">
		<input type="hidden" value="${role.id }" name="role_id"/>
		<c:forEach items="${privileges }" var="p">
			<input type="checkbox" value="${p.id }" name="privilege"/>${p.name }<br/>
		</c:forEach>
		<input type="submit" value="授权" />
	</form>
</body>
</html>