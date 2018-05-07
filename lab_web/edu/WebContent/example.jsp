<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="my1" uri="http://myTag.com" %>
    <%@ taglib prefix="my2" tagdir="/WEB-INF/tags/tag" %>
    <%@ taglib prefix="my3" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- <my1:first>Hello</my1:first> --%>
	
	<my1:second num2="10" num1="20"/>
	
	
	<my2:line/>
	<my2:time/>
	
	<my3:sum num2="3" num1="2"/>

</body>
</html>