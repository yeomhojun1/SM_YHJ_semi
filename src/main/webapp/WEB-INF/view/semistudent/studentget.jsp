<%@page import="kh.yhjsemi.week.model.vo.SemiWeekVo"%>
<%@page import="kh.yhjsemi.student.model.vo.SemiStudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>${mid2.studentName }학생 월별 정보</h2>
	<table border=1>
		<tr>
			<td>주차</td>
			<td>선생님 번호</td>
			<td>학생 번호</td>
			<td>예상 진도</td>
			<td>학습 내용</td>
			<td>선생님 코멘트</td>
			<td>달성율</td>
			<td>이번주 시험 점수</td>
		</tr>
		
			<tr>
				<td>${mid2.monthNo }</td>
				<td>${mid2.tcid }</td>
				<td>${mid2.stid }</td>
				<td>${mid2.expect }</td>
				<td>${mid2.study }</td>
				<td>${mid2.stComment }</td>
				<td>${mid2.acheive }</td>
				<td>${mid2.weekScore }</td>
				
			</tr>


	</table>
</body>
</html>