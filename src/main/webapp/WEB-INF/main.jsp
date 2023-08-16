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
<form action="<%=request.getContextPath() %>/sm/login" method="post">
	id : <input type="text" name="meid"><br>
	password : <input type="password" name="mpwd"><br>
	 type : <select name="mtype">
                    <option value="S" label="학생" ></option>
                    <option value="T" label="선생님"></option>
                    <option value="A" label="학원"></option>
                </select><br>
	<input type="submit" onclick="msg()" value="로그인">
	</form>
	<script>
	function msg(){
	var msg = '${successFailMsg}';
		if(msg!=null){
		alert(msg);
		}
	}
</script>
</body>
</html>