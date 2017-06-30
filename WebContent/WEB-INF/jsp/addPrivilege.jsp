<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加权限</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath }/AddPrivilege">
		权限名：<input type="text" name="name"/>
		描述：<textarea rows="3" cols="20"  name="description"></textarea>
		<input type="submit" value="添加">
	</form>
</body>
</html>