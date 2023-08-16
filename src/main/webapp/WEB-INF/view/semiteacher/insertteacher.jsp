<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="sm-header">
<h2><a href="<%=request.getContextPath()%>/sm/home">염호준 수학</a></h2>
</div>
<h2>선생님 등록</h2>
	<div class="container">
		<form action="<%=request.getContextPath()%>/sm/teacher/insert.do" method="post">

			<table>
				<tr>
					<td>선생님 사번</td>
					<td><input type="text" name="mid"></td>
				</tr>
				<tr>
					<td>선생님 이름</td>
					<td><input type="text" name="teacherName"></td>
				</tr>
				<tr>
					<td>입사날짜</td>
					<td><input type="date" name="entranceDate"></td>
				</tr>
				<tr>
					<td>학원 번호</td>
					<td><input type="text" name="acaNo"></td>
				</tr>
				
	
			</table>
			<button type="submit">선생님 등록</button>
		</form>



	</div>
		<div class="sm-footer">
<h4>저작권 관련</h4>
</div>
</body>
</html>