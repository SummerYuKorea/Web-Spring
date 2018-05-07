<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>&lt;fmt:formatNumber&gt;</h1>
	<fmt:formatNumber value="1234567890.12356789"/><br/> <%-- 1,234,567,890.124 일케 나옴--%>
		<%--독일에서는 천자리에 쩜을 쓰고 소숫점에 ,을씀  oh my god
			그래서 크롬에서 언어설정 바꾸면  format도 따라서 바뀐다능--%>
	<fmt:formatNumber value="1234567890.12356789" groupingUsed="false"/><br/><%--true가 디폴트 --%>
	<fmt:formatNumber value="1234567890.12356789" groupingUsed="false" maxFractionDigits="6"/><br/>
	
	<br/>
	<fmt:formatNumber value="0.51" type="percent"/><br/>
	<fmt:formatNumber value="1230" type="currency"/><br/> <%--해당언어설정에 따라!지금은 원 기호 --%>

</body>
</html>