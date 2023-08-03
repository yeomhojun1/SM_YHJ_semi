<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/sm/login" method="post">
	id : <input type="text" name="mid"><br>
	password : <input type="password" name="mpwd"><br>
	type : <input type="text" name="mtype"> <br>
	<input type="submit" value="로그인">
</body>
</html>