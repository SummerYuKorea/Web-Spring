<%@page import="javax.servlet.http.Cookie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>쿠키 생성/전송</h1>
<%
	// 1. Cookie 객체 생성: new Cookie(name, value)
	Cookie c1=new Cookie("userid", "admin");
	
	// 2. Cookie 객체의 속성 설정
	// 	setMaxAge(초): 쿠키를 브라우저에서 저장할 시간(유효기간)
	c1.setMaxAge(60*60);//60초*60분// 1시간의 초단위
	c1.setHttpOnly(true); //쿠키를 접근해서 전송하거나 읽거나 하는 것은 HTTP프로토콜을 통해서만 가능하다
							//자바스크립트에서 의도적으로 쿠키가 노출되거나 누군가 변경하거나 하는 일을 막을 수 있다.
							
	// 3. 쿠키 전송: response.addCookie(cookie)
	response.addCookie(c1);
	
	
	Cookie c2=new Cookie("nickname","summer");
	c2.setMaxAge(30);
	response.addCookie(c2); //response에저장되는순간부터 30초
%>

	<h2>쿠키 전송 성공</h2>
	<a href="02_getCookie.jsp">생성된 쿠키 확인</a>

</body>
</html>