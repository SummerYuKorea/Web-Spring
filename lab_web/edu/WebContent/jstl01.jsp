<%@page import="java.util.*, com.edu.customTag.Contact" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL01</title>
</head>
<body>
 
 
 <%--
 	
 	[1] Core Tag
 	
 	1.<c:set/>, <c:remove/> :변수의 선언, 제거
 	
 		<c:set var="변수이름" value="변수값" scope="page|request|session|application" />

 	2.<c:out var="변수명" default="null일 경우 기본값" /> :변수의 출력
 	
 	3.<c:if/> :조건문. else 구문이 없다.
 	
 	4.<c:choose/>, <c:when/>, <c:otherwise/> :자바의 switch문과 비슷
 
 	5.<c:forEach/> :반복문. 
 					정수 범위내의 반복(자바의 for 문)과 컬렉션내의 반복(자바의 Iterator와 Enumeration 클래스)을 지원한다.
 
 	6.<c:forTokens/> :문자열을 주어진 구분자(delimiter)로 분할 하여 반복문을 실행
 	
--%>























<%
ArrayList<Contact> list = new ArrayList<>();
list.add(new Contact("밴","22"));
list.add(new Contact("헤","14"));
list.add(new Contact("켄","07"));

request.setAttribute("ContactList", list);
%>



</body>
</html>