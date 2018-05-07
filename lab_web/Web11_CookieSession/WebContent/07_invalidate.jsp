<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>세션 무효화(invalidate)</h1>
<%
	session.invalidate();//세션 객체를 지워버림//로그아웃할 때 사용하는 메소드

	//현재 세션이 유효(valid)한 지 체크
	if(request.isRequestedSessionIdValid()){
		out.println("유효한 세션<br/>");
	}else {
		out.println("유효하지 않은 세션<br/>");
	}
%>

</body>
</html>