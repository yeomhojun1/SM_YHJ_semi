<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="sm-header">
		<h2>
			<a href="<%=request.getContextPath()%>/sm/home">염호준 수학</a>
		</h2>
	</div>
	<h2>

		<a href="<%=request.getContextPath()%>/sm/board/list">공지사항 </a>
	</h2>
	<h2>멤버등록</h2>
	<div class="container">
		<form action="<%=request.getContextPath()%>/sm/member/insert.do"
			method="post">

			<table>
				<tr>
					<td>멤버 아이디</td>
					<td><input type="text" name="mid"></td>
				</tr>
				<tr>
					<td>멤버 비밀번호</td>
					<td><input type="text" name="mpwd"></td>
				</tr>
				<tr>
					<td>멤버 타입</td>
					<td><input type="text" name="mtype"></td>
				</tr>


			</table>
			<button type="submit">멤버등록</button>
		</form>



	</div>
	<div class="sm-footer">
		<h4>저작권 관련</h4>
	</div>
</body>
</html>