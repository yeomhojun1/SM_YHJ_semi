<%@page import="kh.yhjsemi.teacher.model.vo.SemiTeacherVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${mname } 선생님반 리스트</title>
</head>
<body>

	<h2>${mname } 선생님반 리스트</h2>
	<div>
		<a href="<%=request.getContextPath()%>/sm/student/insert">학생등록</a>
	</div>
	<table border="1">
		<tr>
			<td>선생님 사번</td>
			<td>선생님 이름</td>
			<td>입사날짜</td>
			<td>학원 번호</td>
			<c:forEach items="${ semiteacherlist }" var="item">
				<tr>
					<td><a
						href="<%=request.getContextPath()%>/sm/teacher/get?mid=${item.mid }">${item.mid }</td>
					<td><a
						href="<%=request.getContextPath()%>/sm/teacher/get?mid=${item.mid }">${item.teacherName }</td>
					<td>${ item.entranceDate}</td>
					<td>${ item.acaNo}</td>
				</tr>
			</c:forEach>
			>
	</table>
</body>
</html>