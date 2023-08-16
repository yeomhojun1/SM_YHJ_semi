<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
.sm-header{
background: beige;
text-align: center;
height: 150px;
}
.sm-footer{
background: beige;
text-align: center;
height: 100px;
}


</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="sm-header">
<h2><a href="<%=request.getContextPath()%>/sm/home">염호준 수학</a></h2>
</div>
<div>
	<form action="<%=request.getContextPath()%>/sm/login" method="post">
		id : <input type="text" name="meid"><br> 
		password : <input
			type="password" name="mpwd"><br> 
		type : <select
			name="mtype">
			<option value="S" label="학생"></option>
			<option value="T" label="선생님"></option>
			<option value="A" label="학원"></option>
			</select><br> 
		<input type="submit"  value="로그인">
	</form>
<div class="sm-footer">
<h4>저작권 관련</h4>
</div>
</body>
</html>