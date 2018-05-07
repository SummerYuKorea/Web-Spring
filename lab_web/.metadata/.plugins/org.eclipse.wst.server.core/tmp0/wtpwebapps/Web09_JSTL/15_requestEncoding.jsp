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

	<h1>&lt;fmt:requestEncoding&gt;</h1>
	<form method="post">
		<input type="text" name="userName" placeholder="이름 입력하세요"/>
		<input type="submit" value="제출"/>
	</form>
	<hr/>
	
	<%--request.setCharacterEncoding("UTF-8"); --%>
	<fmt:requestEncoding value="UTF-8"/> <%--위와 같은! 역할 하는것! 하지만 주로서블릿에서 doPost하게되어서 뭐 이코드는 많이 안쓸듯~--%>
	이름: ${param.userName }<br/>
</body>
</html>