<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page errorPage="error.jsp" %> 
<%--이 jsp를 실행하다가 error를 만나게 되면(자바코드에서 Exception발생하면) error.jsp로 보내라~(넘어가도 상단의 주소는 안바뀜!) --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>Directive를 사용한 에러 페이지 처리</h1>
	<p>나눗셈 결과: <%=(123/0) %></p>

</body>
</html>