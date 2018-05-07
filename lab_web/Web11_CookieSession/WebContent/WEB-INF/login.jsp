<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<form action="login" method="post">
		<input type="text" required="required" name="userid" placeholder="아이디"/><br/>
		<input type="password" required name="userpw" placeholder="비밀번호"/><br/>
		<input type="submit" value="로그인"/>
	</form>

</body>
</html>