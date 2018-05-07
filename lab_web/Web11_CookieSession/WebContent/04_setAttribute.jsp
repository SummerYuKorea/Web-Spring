<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>세션에 정보 저장</h1>
<%
	request.setAttribute("id", "admin_req");
	session.setAttribute("id", "admin_session");
%>

	Request와 Session에 id 저장 성공<br/>
	<a href="05_getAttribute.jsp">Attribute 확인</a>

</body>
</html>