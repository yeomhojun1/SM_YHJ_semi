<%@page import="java.util.List"%>
<%@page import="kh.yhjsemi.week.model.vo.SemiWeekVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body>
<script>
	function logoutmsg(){
	var msg = '${logoutmsg}';
		if(msg!=null){
		alert(msg);
		}
	}
</script>
<div class="sm-header">
<h2><a href="<%=request.getContextPath()%>/sm/home">염호준 수학</a></h2>
</div>
	<c:choose>
		<c:when test="${not empty loginVo }">
			<h2>${loginVo.mname }님반갑습니다</h2>
			<form action="<%=request.getContextPath()%>/sm/logout" method="get">
				<button type="submit" onclick="logoutmsg">로그아웃</button>
			</form>
			</td>
		</c:when>
		<c:when test="${empty loginVo }">
			<td><a href="<%=request.getContextPath()%>/main"></a></td>
		</c:when>
	</c:choose>
	<hr>
	<h2>
		<a href="<%=request.getContextPath()%>/sm/board/list">공지사항 </a>
	</h2>
	<%
	List<SemiWeekVo> result = (List<SemiWeekVo>) request.getAttribute("semiweeklist");
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
		for (int i = 0; i < result.size(); i++) {
			SemiWeekVo vo = result.get(i);
		%>
		<tr>
			<td><%=vo.getMonthNo()%></td>
			<td><%=vo.getTcid()%></td>
			<td><%=vo.getStid()%></td>
			<td><%=vo.getExpect()%></td>
			<td><%=vo.getStudy()%></td>
			<td><%=vo.getStComment()%></td>
			<td><%=vo.getAcheive()%></td>
			<td><%=vo.getWeekScore()%></td>
		</tr>
		<%
		}
		%>


	</table>
		<div class="sm-footer">
<h4>저작권 관련</h4>
</div>
</body>
</html>