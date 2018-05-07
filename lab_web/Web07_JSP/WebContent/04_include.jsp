<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>

<style>
 .header{
 	background-color:lightpink;
 	font-size: 200%;
 	text-align:center;
 	height: 60px;
 }
</style>

</head>
<body>
	


	<%-- header 파일(jspf)을 include --%>
	<%@ include file="header.jspf" %>
	
	<h1>include Directive(지시자)</h1>
	
	<div><p>본문입니당~</p></div>
	
	<%-- footer 파일(jspf)을 include --%>
	<%@ include file="footer.jspf" %>
	
	
<%--
	include 지시자(directive) 동작 원리:
	include를 사용해서 다른파일(jsp, jspf)을 포함시키면,
	하나의 JSP 파일로 합쳐진 이후에, 서블릿 클래스로 변환(한개의 Servlet이 됨)
 --%>

</body>
</html>