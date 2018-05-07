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
	<h1>&lt;c:choose&gt;</h1>
	
	<form action="" method="get">
		<select name="color">
			<option value="1">빨강</option>
			<option value="2">초록</option>
			<option value="3">파랑</option>
		</select>
		<input type="submit" value="선택"/>
	</form>
	<hr/>
	
	<c:choose> <%-- switch-case같은 기능 (그리고 else if 같이 제외시키고 작동하지)--%>
		<c:when test="${param.color eq 1 }">
			<c:set var="bgColor" value="red"/>
			<c:set var="text" value="빨강"/>
		</c:when>
		
		<c:when test="${param.color eq 2 }">
			<c:set var="bgColor" value="green"/>
			<c:set var="text" value="초록"/>
		</c:when>
		
		<c:when test="${param.color eq 3 }">
			<c:set var="bgColor" value="blue"/>
			<c:set var="text" value="파랑"/>
		</c:when>
		
		<c:otherwise>
			<c:set var="bgColor" value="white"/>
			<c:set var="text" value="몰라요"/>
		</c:otherwise>
	</c:choose>
	
	<div style="background-color: ${bgColor};">${text}</div>

</body>
</html>