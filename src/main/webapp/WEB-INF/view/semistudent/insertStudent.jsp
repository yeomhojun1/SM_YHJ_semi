<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>
		<a href="<%=request.getContextPath()%>/sm/home">홈으로 </a>
	</h2>
<h2>학생등록</h2>
	<div class="container">
		<form action="<%=request.getContextPath()%>/sm/student/insert.do" method="post">

			<table>
				<tr>
					<td>학생번호</td>
					<td><input type="text" name="mid2"></td>
				</tr>
				<tr>
					<td>학생이름</td>
					<td><input type="text" name="studentName"></td>
				</tr>
				<tr>
					<td>시험점수</td>
					<td><input type="number" name="examScore"></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="date" name="birthday"></td>
				</tr>
				<tr>
					<td>입학날짜 yy-mm-dd</td>
					<td><input type="date" name="enterDate"></td>
				</tr>
				<tr>
					<td>특이사항</td>
					<td><input type="textarea" name="important"></td>
				</tr>
				<tr>
					<td>선생님 번호</td>
					<td><input type="text" name="mid"></td>
				</tr>
				<tr>
					<td>학부모 번호</td>
					<td><input type="text" name="tele"></td>
				</tr>
				
	
			</table>
			<button type="submit">학생등록</button>
		</form>



	</div>
</body>
</html>