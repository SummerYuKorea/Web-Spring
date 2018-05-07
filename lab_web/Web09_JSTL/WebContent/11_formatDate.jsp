<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>&lt;fmt:formatDate&gt; 태그</h1>
	<c:set var="now" value="<%=new Date() %>"/>
	현재시간: <c:out value="${now }"></c:out><br/><br/>
	
	<h2>formatDate type 속성</h2>
	기본값: <fmt:formatDate value="${now }"/><br/>
	Date: <fmt:formatDate value="${now }" type="date"/><br/>
	Time: <fmt:formatDate value="${now }" type="time"/><br/>
	Both: <fmt:formatDate value="${now }" type="both"/><br/><br/>
	
	<h2>dateStyle, timeStyle 속성</h2>
	Long:
	<fmt:formatDate value="${now }" type="both" dateStyle="long" timeStyle="long"/><br/>
	Short:
	<fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="short"/><br/>
	Full:
	<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/><br/><br/>
		<%--
		Long: 2017년 4월 17일 (월) 오전 10시 20분 33초
		Short: 17. 4. 17 오전 10:20
		Full: 2017년 4월 17일 월요일 오전 10시 20분 33초 KST --%>
		
	<h2>pattern 속성</h2>
	<fmt:formatDate value="${now }" pattern="yyyy/MM/dd hh:mm:ss"/>
		
	

</body>
</html>