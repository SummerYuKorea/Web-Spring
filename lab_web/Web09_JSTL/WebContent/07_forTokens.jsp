<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>&lt;c:forTokens&gt; 태그</h1>
	<c:forTokens items="2017-04-14 16:18:18" delims="- :" var="number">
		${number}<br/>
	</c:forTokens>
	
	<%Date date=new Date(); %>
	<%=date %>
	<c:forTokens items="<%=new Date().toString()%>" delims=": " var="number">
		${number}<br/>
	</c:forTokens>

</body>
</html>