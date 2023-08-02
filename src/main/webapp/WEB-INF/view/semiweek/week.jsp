<%@page import="java.util.List"%>
<%@page import="kh.yhjsemi.week.model.vo.SemiWeekVo"%>
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
	List<SemiWeekVo> result = (List<SemiWeekVo>)request.getAttribute("semiweeklist");
	%>
	<h2>학생 월별 정보</h2>
	<table border=1>
		<tr>
			<td>주차</td>
			<td>선생님 번호</td>
			<td>학생 번호</td>
			<td>예상 진도</td>
			<td>학습 내용</td>
			<td>선생님 코멘트</td>
			<td>달성율</td>
			<td>이번주 시험 점수</td>
		</tr>
		<%
		for(int i =0;i<result.size();i++){
			SemiWeekVo vo = result.get(i);
		
		%>
			<tr>
				<td><%=vo.getMonthNo() %></td>
				<td><%=vo.getTcid() %></td>
				<td><%=vo.getStid() %></td>
				<td><%=vo.getExpect() %></td>
				<td><%=vo.getStudy()%></td>
				<td><%=vo.getStComment() %></td>
				<td><%=vo.getAcheive() %></td>
				<td><%=vo.getWeekScore() %></td>
			</tr>
<%} %>


	</table>
</body>
</html>