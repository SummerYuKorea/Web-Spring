<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키삭제 - 유효기간 만료</h1>
<%
	//브라우저가 저장하고 있는 쿠키를 삭제하고 싶으면
	// 삭제하려고 하는 쿠키 이름으로 쿠키 객체를 생성하고 maxAge를 0으로 설정
	Cookie c=new Cookie("userid","");
	c.setMaxAge(0);
	response.addCookie(c);  //덮어쓰기
	out.println("쿠키 삭제됨<br/>");
%>

	<a href="02_getCookie.jsp">쿠키 확인</a>


</body>
</html>