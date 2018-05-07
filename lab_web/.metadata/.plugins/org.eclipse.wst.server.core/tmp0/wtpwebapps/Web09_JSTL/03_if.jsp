<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style >
	div{
		font-size: 200%;
		font-weight: bold;
	}
</style>
</head>
<body>

	<h2>색상 선택 결과</h2>
<%
	String color= request.getParameter("color");
	switch(color){
	case "r":out.write("<div style='color:red;'>빨강</div>");break;
	case "g":out.write("<div style='color:green;'>초록</div>");break;
	case "b":out.write("<div style='color:blue;'>파랑</div>");break;
	}
%>

	<hr/>
	
	<h2>&lt;c:if&gt; 사용방법</h2> <%--if태그는 else가 없어~ 참고 --%>
	<c:if test="${param.color eq 'r'}"> <!-- equals 메소드 호출한것 -->
		<div style="color:red; text-decoration: underline;">빨강~</div>
	</c:if>
	
	<c:if test="${param.color eq 'g'}"> 
		<div style="color:green; text-decoration: underline;">초록~</div>
	</c:if>
	
	<c:if test="${param.color eq 'b'}"> 
		<div style="color:blue; text-decoration: underline;">파랑~</div>
	</c:if>
	
	<%-- EL은 디렉티브안에서 못씀 Scriptlet, Declaration, Expreesion 안에서도 못씀
		이거빼곤 어디서나쓰일수있음! style태그안에도, 어디안에도~=> EL의 강력한 점 --%>
</body>
</html>