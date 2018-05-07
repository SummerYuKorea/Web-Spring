<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JavaBeans2</title>
</head>
<body>

	<jsp:useBean id="hero" class="kr.willit.beans.Hero" scope="page"/>
	
	<jsp:getProperty property="name" name="hero"/>/
	<jsp:getProperty property="level" name="hero"/><br>
	
	
	
	
	<jsp:setProperty property="*" name="hero"/>
	<!-- 각 form의 name속성에 해당하는 setXxx() 메소드를 찾아 프로퍼티를 설정 -->
	
	
	
	
	<hr>
	
	<jsp:getProperty property="name" name="hero"/>/
	<jsp:getProperty property="level" name="hero"/><br>
	
	<hr>
	
	<%=hero.getName() %>/
	<%=hero.getLevel() %>
	
	

</body>
</html>