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
<div>
<table border=1>
	<tr>
		<td>번호</td>
		<td>공지사항 제목</td>
		<td>작성자</td>
		<td>삭제 버튼</td>
</tr>
<c:forEach items="${semiboardlist}" var="item">
	<tr>
	<td><a href="<%=request.getContextPath()%>/sm/board/bcontent?bno=${item.bno }">${item.bno }</td>
	<td><a href="<%=request.getContextPath()%>/sm/board/bcontent?bno=${item.bno }">${item.btitle }</td>
	<td>${item.bwriter }</td>
	<td><form
						action="<%=request.getContextPath()%>/sm/board/delete"
						method="post">
						<input type="hidden" name="bno" value="${item.bno }">
						<button type="submit">delete</button>
					</form></td>
	
</tr>
</c:forEach>
</table>
</div>
<div>
		<a href="<%=request.getContextPath()%>/sm/board/insert">글 등록</a>
	</div>

</body>
</html>