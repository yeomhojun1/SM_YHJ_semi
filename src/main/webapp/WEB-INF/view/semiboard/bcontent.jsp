<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

	<h2>공지사항 상세</h2>
	<table border=1>
		<tr>글 제목 : ${bcontent.btitle }
		</tr>
		<tr>작성자 : ${bcontent.bwriter }
		</tr>
		<tr>글 내용 : ${bcontent.bcontent }
		</tr>


	</table>
	<h2>
		<a href="<%=request.getContextPath()%>/sm/board/list">공지사항 </a>
	</h2>
	<div class="sm-footer">
<h4>저작권 관련</h4>
</div>
</body>
</html>