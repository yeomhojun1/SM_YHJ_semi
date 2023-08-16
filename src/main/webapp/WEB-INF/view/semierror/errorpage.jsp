<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>Insert title here</title>
</head>
<body>
<div class="sm-header">
<h2><a href="<%=request.getContextPath()%>/sm/home">염호준 수학</a></h2>
</div>
	<h2>권한이 없습니다</h2>
	<h4>
		<a href="<%=request.getContextPath()%>/sm/home">홈으로 </a>
	</h4>
	<div class="sm-footer">
<h4>저작권 관련</h4>
</div>
</body>
</html>