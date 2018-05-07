<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<div class="container">
	<h1>로그인 페이지</h1>
	<form action="board-main" method="post"> 
		<input type="text" name="userid" placeholder="아이디 입력"  required="required"
			<%if(request.getParameter("userid")!=null) {%>value="${param.userid}"<%} %>/><br/>
		<input type="password" name="userpw" placeholder="비밀번호 입력" required/><br/>
		<input class="btn btn-default btn-lg" type="submit" value="로그인"
				style="margin:10px"/>
	</form> 
	
	<c:if test="${not empty param.userid }">
		<script>
			alert("회원가입이 완료되었습니다");
		</script>
	</c:if>
</div>
</body>
</html>