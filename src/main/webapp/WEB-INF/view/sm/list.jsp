<%@page import="kh.yhjsemi.student.model.vo.SemiStudentVo"%>
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
List<SemiStudentVo> volist= (List<SemiStudentVo>) request.getAttribute("smlist");
%>
<h2>담당 학생 리스트</h2>
<table border="1">
		<tr>
			<td>학생번호</td>
			<td>학생이름</td>
			<td>나이</td>
			<td>부모전화번호</td>
		</tr>
		<tr>
		<%
		for (int i =0 ; i<volist.size();i++){
			SemiStudentVo vo = volist.get(i);
		%>
		<tr>
			
			<td><a
				href="<%=request.getContextPath()%>/sm/get?sno=<%=vo.getStudentNo()%>">
					<%=vo.getStudentNo()%></a></td>
			<td><%=vo.getStudentName()%></td>
			<td><%=vo.getAge()%></td>
			<td><%=vo.getParentNumber()%></td>

		</tr>
		<%} %>
</body>
</html>