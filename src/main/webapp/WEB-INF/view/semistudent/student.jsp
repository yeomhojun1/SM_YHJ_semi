<%@page import="kh.yhjsemi.student.model.vo.SemiStudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<div>
<form action="#" method="get">
	<input type="search" name="searchword" placeholder="검색">
	<botton type="submit" value="찾기">

</form>
</div>
<c:if test="${not empty searchword }">
	<h3>${searchword } 검색결과</h3>
	<h5>
	<a href="<%= request.getContextPath() %>/sm/student/list">전체보기</a>
	</h5>
</c:if>


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
	
		<c:forEach items="${ semistudentlist }" var="item">
		<tr>
			
			<td><a
					href="<%=request.getContextPath()%>/sm/student/get?mid2=${item.mid2 }">${item.mid2 }</a></td>
			<td><a
					href="<%=request.getContextPath()%>/sm/student/get?mid2=${item.mid2 }">${item.studentName }</a></td>
			<td>${item.examScore }</td>
			<td>${item.birthday }</td>
			<td>${item.enterDate }</td>
			<td>${item.important }</td>
			<td>${item.important }</td>
			<td>${item.mid }</td>
			<td>${item.tele }</td>
			

		</tr>
		</c:forEach>
		</table>
</body>
</html>