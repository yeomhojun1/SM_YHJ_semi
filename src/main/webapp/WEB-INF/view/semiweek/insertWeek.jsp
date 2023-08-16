<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<div class="sm-header">
		<h2>
			<a href="<%=request.getContextPath()%>/sm/home">염호준 수학</a>
		</h2>
	</div>
	<h2>주차별 진도 등록</h2>
	<div class="container">
		<form action="<%=request.getContextPath()%>/sm/teacher/insert.do"
			method="post">

			<table>
				<tr>
					<td>주차</td>
					<td>
					<select name="year">
							<option value="23" label="23"></option>
							<option value="24" label="24"></option>
							<option value="25" label="25"></option>
					</select>년
						<select name="month">
							<option value="01" label="1"></option>
							<option value="02" label="2"></option>
							<option value="03" label="3"></option>
							<option value="04" label="4"></option>
							<option value="05" label="5"></option>
							<option value="06" label="6"></option>
							<option value="07" label="7"></option>
							<option value="08" label="8"></option>
							<option value="09" label="9"></option>
							<option value="10" label="10"></option>
							<option value="11" label="11"></option>
							<option value="12" label="12"></option>
					</select>월
					<select name="week">
							<option value="01" label="1"></option>
							<option value="02" label="2"></option>
							<option value="03" label="3"></option>
							<option value="04" label="4"></option>
							<option value="05" label="5"></option>
						
					</select>주차
					</td>
				</tr>
				<tr>
					<td>선생님 번호</td>
					<td>${loginVo.mid }</td>
				</tr>
				<tr>
					<td>학생 번호</td>
					<td><input type="text" name="stid"></td>
				</tr>
				<tr>
					<td>예상 진도</td>
					<td><input type="text" name="expect"></td>
				</tr>
				<tr>
					<td>진행상황</td>
					<td><input type="text" name="study"></td>
				</tr>
				<tr>
					<td>선생님 코멘트</td>
					<td><input type="text" name="stComment"></td>
				</tr>
				<tr>
					<td>성취율</td>
					<td><input type="text" name="acheive"></td>
				</tr>
				<tr>
					<td>주중 시험 점수</td>
					<td><input type="number" name="weekScore"></td>
				</tr>
				<tr>
					<td>학생 이름</td>
					<td><input type="text" name="studentName"></td>
				</tr>


			</table>
			<button type="submit">주차별 진도 등록</button>
		</form>



	</div>
	<div class="sm-footer">
		<h4>저작권 관련</h4>
	</div>
</body>
</html>