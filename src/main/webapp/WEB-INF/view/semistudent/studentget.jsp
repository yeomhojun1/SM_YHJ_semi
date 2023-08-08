<%@page import="kh.yhjsemi.week.model.vo.SemiWeekVo"%>
<%@page import="kh.yhjsemi.student.model.vo.SemiStudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${mid2.get(0).studentName } 주차별 정보</title>
</head>
<body>
	<h2>${mid2.get(0).studentName } 주차별 정보</h2>
	<form
		action="<%=request.getContextPath()%>/sm/student/search?searchword=${s}"
		method="get">
		<input type="search" name="searchword" placeholder="검색"> <input
			type="submit" value="찾기">

	</form>
${mname }
${successFailMsg }
	<table border=1>
		<tr>
			<td>주차</td>
			<td>선생님 번호</td>
			<td>예상 진도</td>
			<td>학습 내용</td>
			<td>선생님 코멘트</td>
			<td>달성율</td>
			<td>이번주 시험 점수</td>
			
		</tr>
		<c:forEach items="${mid2 }" var="item">
			<tr>
				<td>${item.monthNo }</td>
				<td>${item.tcid }</td>
				<td>${item.expect }</td>
				<td>${item.study }</td>
				<td>${item.stComment }</td>
				<td>${item.acheive }</td>
				<td>${item.weekScore }</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>