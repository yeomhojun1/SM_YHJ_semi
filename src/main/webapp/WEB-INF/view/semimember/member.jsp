<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 리스트</title>
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

	<h2>멤버 리스트</h2>

	<div>
		<form
			action="<%=request.getContextPath()%>/sm/student/search?searchword=${s}"
			method="get">

			<input type="search" name="searchword" placeholder="검색"> <input
				type="submit" value="찾기">

		</form>
	</div>
	<div>
		<a href="<%=request.getContextPath()%>/sm/member/insert">멤버등록</a>
	</div>

	<table border="1">
		<tr>
			<td>멤버 아이디</td>
			<td>멤버 이름</td>
			<td>멤버 타입</td>
			<td>삭제 버튼</td>
		</tr>
		<c:forEach items="${ semimemberlist }" var="item">
			<tr>

				<c:choose>
					<c:when test="${item.mtype eq '선생님' }">
						<td><a
							href="<%=request.getContextPath()%>/sm/teacher/get?mid=${item.mid }">${item.mid }</a>
						</td>
					</c:when>
					<c:when test="${item.mtype eq  '학생' }">
						<td><a
							href="<%=request.getContextPath()%>/sm/student/get?mid2=${item.mid }">${item.mid }</a>
						</td>
					</c:when>
					<c:when test="${item.mtype eq '학원' }">
						<td><a href="<%=request.getContextPath()%>/sm/member/list">${item.mid }</a>
						</td>
					</c:when>
				</c:choose>
				<td>${item.mtype }</td>
				<td>${item.mname }</td>

				<td><form
						action="<%=request.getContextPath()%>/sm/member/delete"
						method="post">
						<input type="hidden" name="mid" value="${item.mid }">
						<button type="submit">delete</button>
					</form></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>