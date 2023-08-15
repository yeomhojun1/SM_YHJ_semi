<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${mname}학원선생님 정보</title>
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
<h2>
		<a href="<%=request.getContextPath()%>/sm/home">홈으로 </a>
	</h2>
	<c:choose>
		<c:when test="${not empty loginVo }">
			<h2>${loginVo.mname }님반갑습니다</h2>
			<form action="<%=request.getContextPath()%>/sm/logout" method="get">
				<button type="submit" onclick="logoutmsg()">로그아웃</button>
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
	<hr>
	<form
		action="<%=request.getContextPath()%>/sm/student/search?searchword=${s}"
		method="get">
		<input type="search" name="searchword" placeholder=" 학생 검색"> <input
			type="submit" value="찾기">

	</form>
	<div>
		<a href="<%=request.getContextPath()%>/sm/member/insert">멤버등록</a>
	</div>
	<div>
		<a href="<%=request.getContextPath()%>/sm/member/list">멤버 전체 보기</a>
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
</body>
</html>