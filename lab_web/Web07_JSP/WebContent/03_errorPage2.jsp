<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>배포 관리자(web.xml)을 사용한 에러 페이지 처리</h1>
	
	<a href="none.jsp">없는 링크//링크 안만들었어!(404 에러)</a>
	
	<p>계산 결과 :<%=(123/0.0) %> </p> <!-- 이거 0.0으로 실수면 infinity반환하고 정수로 나누면 code500에러남 -->

</body>
</html>