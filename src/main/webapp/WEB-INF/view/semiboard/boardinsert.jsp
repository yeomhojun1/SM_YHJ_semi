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
<h2>글쓰기</h2>
<div class="sm-header">
<h2><a href="<%=request.getContextPath()%>/sm/home">염호준 수학</a></h2>
</div>
	<div class="container">
		<form action="<%=request.getContextPath()%>/sm/board/insert.do" method="post">

			<table>
				<tr>
					<td>글 제목</td>
					<td><input type="text" name="btitle"></td>
				</tr>
				<tr>
					<td>글 내용</td>
					<td><textarea type="textarea" name="bcontent"  rows="10" cols="50"> </textarea></td>
				</tr>
			
	
			</table>
			<button type="submit">글 등록</button>
		</form>
	</div>
	<div class="sm-footer">
<h4>저작권 관련</h4>
</div>
</body>
</html>