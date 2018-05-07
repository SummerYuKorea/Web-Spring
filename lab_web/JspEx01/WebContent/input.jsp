<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Input</title>
</head>
<body>

	<!-- request, response -->
	
	<form action="output.jsp" method="post">
		ID: <input type="text" name="id"/><br>
		PWD: <input type="password" name="pwd"/><br>
		<input type="submit" value="로그인"/>
	</form>
		<a href="output.jsp">로그아웃</a>
	
</body>
</html>