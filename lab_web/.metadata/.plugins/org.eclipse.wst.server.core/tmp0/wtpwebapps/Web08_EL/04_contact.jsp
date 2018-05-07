<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>연락처 입력</h1>
	<form action="insertContact" method="get">
		<input type="text" name="name" placeholder="이름"/><br/>
		<input type="tel" name="phone" placeholder="전화번호"/><br/>
		<input type="text" name="email" placeholder="이메일"/><br/>
		<input type="submit" value="입력"/>
	</form>

</body>
</html>