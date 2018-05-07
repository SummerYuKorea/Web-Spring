<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>

	<h1>EL(Expression Language): 표현식 언어, 식 언어</h1>
	
	<%-- HTML형식 --%>
	Hello, JSP!<br/>
	
	<%-- ScriptLet 형식 --%>
	<%
	out.write("Hello, JSP!<br/>");
	%>
	
	<%-- Expression(표현식) --%>
	<%="Hello, JSP!<br/>" %>
	
	<%-- EL(Expression Language) --%>
	${"Hello, JSP!"}
</body>
</html>