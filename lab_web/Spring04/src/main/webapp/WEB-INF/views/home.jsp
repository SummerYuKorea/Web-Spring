<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<% System.out.println("=======home.jsp 호출"); %>

<c:if test="${not empty login_id }"> 
<!-- not empty는 not null  && 빈 문자열("") 아님 -->
${login_id}님, 환영합니다!<br/>
<button id="btn_logout" type="button">로그아웃</button>
</c:if>

<c:if test="${empty login_id}">
	<form action="member/login-post" method="post">
		<input type="text" name="userid" placeholder="USER ID" required="required" autofocus="autofocus"/>
		<input type="password" name="userpw" placeholder="PASSWORD" required="required" autofocus="autofocus"/>
		<input type="submit" value="로그인">
	</form>
</c:if>

<hr/>
<a href="">게시판 메인</a>
</body>
</html>
