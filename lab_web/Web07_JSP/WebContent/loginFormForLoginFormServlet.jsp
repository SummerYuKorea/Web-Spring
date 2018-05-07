<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginFormForLoginFormServlet</title>
</head>
<body>

	<h1>로그인 양식</h1>
	<form action="loginCheck.jsp" method="post"><!-- 로그인은 포스트방식 이용햐져 -->
		<input type="text" name="id" placeholder="ID"/><br/>
		<input type="password" name="passwd" placeholder="PASSWORD"/><br/><br/>
		<input type="submit" value="로그인~"/>
	</form>

</body>
</html>