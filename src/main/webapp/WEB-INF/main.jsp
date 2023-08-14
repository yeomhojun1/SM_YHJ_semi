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
	id : <input type="text" name="meid"><br>
	password : <input type="password" name="mpwd"><br>
	 type : <select name="mtype">
                    <option value="S" label="학생" ></option>
                    <option value="T" label="선생님"></option>
                    <option value="A"label="학원"></option>
                </select><br>
	<input type="submit" value="로그인">
	</form>
</body>
</html>