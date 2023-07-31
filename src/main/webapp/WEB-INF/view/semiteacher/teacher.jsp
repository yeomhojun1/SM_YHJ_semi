<%@page import="kh.yhjsemi.teacher.model.vo.SemiTeacherVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<SemiTeacherVo> result = (List<SemiTeacherVo>)request.getAttribute("semiteacherlist");
	%>
	<h2>선생님 리스트</h2>
	<table border="1">
	<tr>
	<td>선생님 사번</td>
	<td>선생님 이름</td>
	<td>입사날짜</td>
	<td>학원 번호</td>
		<%
		for(int i =0;i<result.size();i++){
			SemiTeacherVo vo = result.get(i);
		
		%>
	<tr>
	<td><%=vo.getMid() %></td>
	<td><%=vo.getTeacherName() %></td>
	<td><%=vo.getEntranceDate() %></td>
	<td><%=vo.getAcaNo() %></td>
	
	<% } %>
	</table>
</body>
</html>