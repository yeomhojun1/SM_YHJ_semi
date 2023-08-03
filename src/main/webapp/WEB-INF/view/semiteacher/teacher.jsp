<%@page import="kh.yhjsemi.teacher.model.vo.SemiTeacherVo"%>
<%@page import="java.util.List"%>
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
	
	<h2>선생님 리스트</h2>
	<table border="1">
	<tr>
	<td>선생님 사번</td>
	<td>선생님 이름</td>
	<td>입사날짜</td>
	<td>학원 번호</td>
		<c:forEach items="${ semiteacherlist }" var="item">
	<tr>
	<td><a href="<%=request.getContextPath()%>/sm/teacher/get?mid2=${item.mid }">${item.mid }</td>
	<td><a href="<%=request.getContextPath()%>/sm/teacher/get?mid2=${item.mid }">${item.teacherName }</td>
	<td>${ item.entranceDate}</td>
	<td>${ item.acaNo}</td>
	</tr>
	</c:forEach>>
	</table>
</body>
</html>