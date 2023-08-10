<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>글쓰기</h2>
	<div class="container">
		<form action="<%=request.getContextPath()%>/sm/board/insert.do" method="post">

			<table>
				<tr>
					<td>글 제목</td>
					<td><input type="text" name="btitle"></td>
				</tr>
				<tr>
					<td>글 내용</td>
					<td><input type="textarea" name="bcontent"></td>
				</tr>
			
	
			</table>
			<button type="submit">글 등록</button>
		</form>



	</div>
</body>
</html>