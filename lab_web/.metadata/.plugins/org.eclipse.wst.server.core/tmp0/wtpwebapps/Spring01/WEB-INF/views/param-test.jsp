<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>param-test.jsp</h1>
	username: ${username }<br/>  <!-- EL! page에서 찾-> request-> session-> application 범위에서 찾지  -->
	age: ${age }<br/>
</body>
</html>