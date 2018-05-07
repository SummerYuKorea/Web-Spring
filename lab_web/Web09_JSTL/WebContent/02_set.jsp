<%@page import="edu.web1.model.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>JSTL 변수(property) 선언과 사용</h1>
<%--
	웹 애플리케이션의 Scope(범위)와 JSP내장 객체:
	1. Page Scope: 하나의 JSP 페이지를 처리할 떄 사용되는 범위
			PageContext pageContext
	2. Request Scope: 하나의 요청(request)을 처리할 때 사용되는 범위
			HttpServletRequest request
	3. Session Scope: 웹 브라우저가 실행 중에 유지가 되는 범위(웹브라우저 닫으면 자동 로그아웃되지(로그인유지.하지않으면)
			HttpSession session
	4. Application Scope: 하나의 웹 애플리케이션이 실행 중에 유지되는 범위
			ServletContext application
	각 범위(scope)에 해당하는 객체들은 값들을 저장하고 읽기 위한 메소드를 제공:
			setAttribute(attrName, object),
			getAttribute(attrName)
			
			
	JSTL에서 변수 선언
	<c:set var="변수이름" value="변수값" scope=범위"/>
		여기서 범위란?: page, request, session, application
			defalut값: page 
--%>

<%
	pageContext.setAttribute("name1", "다이버 한결이");	
%>

	이름1: <%=pageContext.getAttribute("name1") %><br/>

	<c:set var="name2" value="짱강사"/>
	<c:set var="name2" value="일도킴" scope="request"/> <!-- 더큰범위에 넣 -->
	이름2: ${name2}<br/>
	이름2: ${pageScope.name2}<br/>
	이름2: ${requestScope.name2}<br/> <!-- request에서 찾겠다 -->
	
		<%--EL의 동작방식?: 
		EL은 변수(property)의 값을 읽어올 때
		별다른 언급이 없으면 pageContext에서 찾기 시작. 못찾으면-> request->session->application순으로 attribute를 찾음(getAttribute) --%>

	<%-- <c:set> 사용해서 객체 선언/사용 --%>
	
<%
	pageContext.setAttribute("c1", new Contact());
	Contact contact= (Contact)pageContext.getAttribute("c1");
	contact.setName("오쌤");
%>
	<c:set var="c2" value="<%=new Contact()%>" /> <%--이런 scriptlet은 어쩔수가 없대 --%>
	<c:set target="${c2}" property="name" value="홍길동"/>
	<%-- ${target.property=value} 이런거네! --%>
	${c2.phone="123-123"}<br/>
	이름: ${c2.name }<br/>
	핸드폰: ${c2.phone }<br/>
	
	<c:set var="c3" value="${c1 }"/>
	<c:set target="${c3 }" property="phone" value="010-5555-5555"/>
	이름: ${c3.name }<br/>
	핸드폰: ${c3.phone }<br/>
	
	c1의 폰넘버? ${c1.phone }
	
</body>
</html>