<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath }/UpdatePrivilegeServlet">
		<input type="hidden" value="${privilege.id }" name="id"/>
		<input type="text" value="${privilege.name }" name="name"/>
		<textarea rows="3" cols="20" name="description">${privilege.description }</textarea>
		<input type="submit" value="确认修改"/>
	</form>
</body>
</html>