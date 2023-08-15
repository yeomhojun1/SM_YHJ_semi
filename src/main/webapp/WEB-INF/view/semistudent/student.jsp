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
<a
							href="<%=request.getContextPath()%>/sm/board/list">공지사항</a>
</h2><hr>
<h2>학생 리스트</h2>
	
<div>
		<form action="<%=request.getContextPath()%>/sm/student/search?searchword=${s}" method="get">

	<input type="search" name="searchword" placeholder="검색">
	<input type="submit" value="찾기">

</form>
</div>


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
			<td>삭제 버튼</td>
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
			<td>${item.mid }</td>
			<td>${item.tele }</td>
			<td><a href="<%=request.getContextPath()%>/sm/student/delete">${item.studentName } 삭제</a>

		</tr>
		</c:forEach>
		</table>
</body>
</html>