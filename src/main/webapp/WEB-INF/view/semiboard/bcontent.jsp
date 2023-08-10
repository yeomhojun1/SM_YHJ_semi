<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>공지사항 상세</h2>
	<table border=1>
		<tr>글 제목 : ${bcontent.btitle }</tr>
		<tr>작성자 : ${bcontent.bwriter }</tr>
		<tr>글 내용 : ${bcontent.bcontent }</tr>
	
	
	</table>
</body>
</html>