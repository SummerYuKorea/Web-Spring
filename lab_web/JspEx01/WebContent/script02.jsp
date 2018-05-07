<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page info="page 지시자 예제입니다." %>
<%@ page import="java.util.*"%>
<%@ page errorPage="errorPage.jsp" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>page 지시자</title>
</head>
<body>
	
	<!-- import -->
	<%-- <%Date d = new Date() %> --%>


	<!-- errorPage와 isErrorPage -->
	<!--  
		에러페이지 띄우는 방법
		1. page 지시자의 errorPage 속성 사용
		-	해당 페이지에서 에러 발생시 띄워줄 에러 페이지를 page 지시자의 errorPage 속성에 명시해 준다.
		
	<%-- 	<%
        	int num = 4/0;
    	%> --%>


		
		
		2. web.xml에서 error-page 태그를 등록하는 방법 (권장)
		-	web.xml을 이용해 예외페이지를 세팅할 때는 page지시자의 errorPage를 사용하면 안된다.
		
	-->
	
	<%-- <%@ include file="heroes.jsp" %> --%>
	

</body>
</html>