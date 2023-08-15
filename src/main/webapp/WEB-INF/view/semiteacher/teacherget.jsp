<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 반학생 정보</title>
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
		<a href="<%=request.getContextPath()%>/sm/board/list">공지사항 </a>
	</h2>
<h2>${mname } 반학생 정보</h2>
	<form
		action="<%=request.getContextPath()%>/sm/student/search?searchword=${s}"
		method="get">
		<input type="search" name="searchword" placeholder="검색"> <input
			type="submit" value="찾기">

	</form>
	<div>
		<a href="<%=request.getContextPath()%>/sm/student/insert">학생등록</a>
	</div>
	<table border=1>
		<tr>
			<td>학생 번호</td>
			<td>학생 이름</td>
			<td>지난 시험 점수</td>
			<td>생년월일</td>
			<td>첫 등원 날짜</td>
			<td>특이사항</td>
			<td>학부모 전화번호</td>
			<td>삭제 버튼</td>
		</tr>
		<c:forEach items="${mid}" var="item">
			<tr>
				<td><a href="<%=request.getContextPath()%>/sm/student/get?mid2=${item.mid2 }">${item.mid2 }</a>
				</td>
				<td><a href="<%=request.getContextPath()%>/sm/student/get?mid2=${item.mid2 }">${item.studentName }</a></td>
				<td>${item.examScore }</td>
				<td>${item.birthday }</td>
				<td>${item.enterDate }</td>
				<td>${item.important }</td>
				<td>${item.tele }</td>
				<td><form action="<%=request.getContextPath()%>/sm/student/delete" method="post"><input type="hidden" name="mid2" value="${item.mid2 }"><button type="submit">delete</button></form> </td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>