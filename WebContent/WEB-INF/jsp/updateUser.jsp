<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/UpdateUserServlet" method="post">
		<input type="hidden" name="id" value="${user.id }"/>
		<input type="text" name="username" value="${user.username }"/>
		<input type="text" name="password" value="${user.password }"/>
		<input type="submit" value="修改"/>
	</form>
</body>
</html>