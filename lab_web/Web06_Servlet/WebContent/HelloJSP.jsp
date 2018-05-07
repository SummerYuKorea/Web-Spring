<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html > <!-- HTML 4.0.1의 규격임 not necessary 필요 없는 것들 지워줘똬 //지워주면 html 5에 맞는 규격됨-->
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<!-- 내부적으로 JSP파일이 Servlet으로 바뀌는 것. 내부적으로 변환된 Servlet클래스가 doGet 메소드등을 만들어 내는 것 -->

	<h1>안녕, JSP!</h1>
	<%
		Date curDate=new Date(); //자바 코드!!!를 사용중 oh~
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateString= sdf.format(curDate);
		
		
	%>
	<h2>현재시간: <%=dateString%></h2>

</body>
</html>