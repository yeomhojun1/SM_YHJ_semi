<%@page import="kh.yhjsemi.student.model.vo.SemiStudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 리스트</title>
</head>
<body>

<%
  List<SemiStudentVo> tc= (List<SemiStudentVo>)request.getAttribute("semistudentlist");
%>
<h2>학생 리스트</h2>
<table border="1">
		<tr>
			<td>학생 아이디</td>
			<td>학생 이름</td>
			<td>전 시험 점수</td>
			<td>생년월일</td>
			<td>입학날짜</td>
			<td>특이사항</td>
			<td>선생님 번호</td>
			<td>학생 전화번호</td>
		</tr>
	
		<%
		for (int i =0 ; i<tc.size();i++){
			SemiStudentVo vo = tc.get(i);
		%>
		<tr>
			
			<td><%=vo.getMid2() %></td>
			<td><%=vo.getStudentName() %></td>
			<td><%=vo.getExamScore() %></td>
			<td><%=vo.getBirthday() %></td>
			<td><%=vo.getEnterDate() %></td>
			<td><%=vo.getImportant() %></td>
			<td><%=vo.getTele() %></td>

		</tr>
		<%} %>
		</table>
</body>
</html>