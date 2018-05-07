<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>&lt;c:remove&gt;</h1>
<%--
	<c:set> 태그를 사용해서 attribute에 설정한 property(변수)를 삭제
--%>
	<c:set var="age" value="16"/> <%--숫자도 문자열으로 줘야해 --%>
	<%-- pageContext.setAttribute("age",16);이랑 똑같! --%>
	<c:set var="age" value="18" scope="request"/> 
	
	age: ${age}<br/>
	
	
	<c:remove var="age" scope="page"/>
	remove 후 age: ${age}<br/>  <%--이러면 18이 나오지 --%>
		<%--단 리무브할때는 scope을 주는게 좋대 
			안주면, pageContext, request, session, application 범위 모드에서 해당 Attribute를 삭제해버림--%>
</body>
</html>