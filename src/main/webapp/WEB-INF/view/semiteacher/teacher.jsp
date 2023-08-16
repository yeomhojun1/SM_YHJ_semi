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
					<h2>${loginVo.mname }님 반갑습니다</h2>
						<form
						action="<%=request.getContextPath()%>/sm/logout"
						method="get">
						<button type="submit" onclick="logoutmsg()">로그아웃</button>
						</form>
						</td>
					</c:when>
					<c:when test="${empty loginVo }">
						<td><a
							href="<%=request.getContextPath()%>/main">${item.mid }</a>
						</td>
					</c:when>
				</c:choose>
				<hr>
				<h2>
		<a href="<%=request.getContextPath()%>/sm/board/list">공지사항 </a>
	</h2>

	<h2>${mname } 선생님반 리스트</h2>
	<div>
		<a href="<%=request.getContextPath()%>/sm/student/insert">학생등록</a>
	</div>
	<div>
		<a href="<%=request.getContextPath()%>/sm/teacher/insert">선생님 등록</a>
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
	</table>
	<div class="sm-footer">
<h4>저작권 관련</h4>
</div>
</body>
</html>