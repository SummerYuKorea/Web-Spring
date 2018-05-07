<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Standard Action Tag</title>
</head>
<body>
	
	<!-- 
		jsp:forward
		서블릿에서 RequestDispatcher 객체의 forward() 메소드 기능을 실행	
	-->
	<%-- <h3>example</h3>
	<jsp:forward page="heroes.jsp" /> --%>
	
	<%-- <%
		String param = request.getParameter("param");
	%>
	<jsp:forward page="<%=param %>" /> --%>
	
	
	
	
	<!-- 
		jsp:include
		서블릿에서 RequestDispatcher 객체의 include() 메소드 기능을 실행	
	-->
	<%-- <h3>--- include 전 ----</h3>
	<jsp:include page="heroes.jsp"/>
	<h3>--- include 후 ----</h3> --%>
	
	<!-- 
		include 지시자를 이용하는 방법 
	-->
	<%-- <h3>--- include 전 ----</h3>
	<%@ include file="heroes.jsp" %>
	<h3>--- include 후 ----</h3> --%>
	
	
	
	
	
	
	
	  
	<%-- 
	
		스크립트 요소를 대체하는 액션 태그 (안중요)
		
		<jsp:declaration> 코드 </jsp:declaration>
		<jsp:scriptlet> 코드 </jsp:scriptlet>
		<jsp:expression> 코드 </jsp:expression>
		<jsp:directive.page contentType="text/html; charset=UTF-8" /> 
	
	--%>
	
	
	

</body>
</html>