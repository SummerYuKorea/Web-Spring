<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 양식</h1>
	<form action="loginPOST" method="post">
		<input type="text" name="userid"/>
		<input type="password" name="userpw"/>
		<input type="submit" value="로그인"/>
	</form>
	<hr/>
	<div>
		아이디: ${param.userid }<br/>
		비밀번호: ${param.userpw }
	</div>

</body>
</html>