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
<h2>공지사항</h2>
<table border=1>
	<tr>
		<td>번호</td>
		<td>공지사항 제목</td>
		<td>작성자</td>
</tr>
<c:forEach items="${semiboardlist}" var="item">
	<tr>
	<td>${item.bno }</td>
	<td>${item.btitle }</td>
	<td>${item.bwriter }</td>
</tr>


</c:forEach>

</table>
</body>
</html>