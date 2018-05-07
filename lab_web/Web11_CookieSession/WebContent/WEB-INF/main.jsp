<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 모바일 디바이스에서 터치줌 등을 지원하기 위해서  -->
<meta name="viewport" content="width=device-width, initial-scale=1"/><!-- 1:기본줌레벨  을 쓰겠다 -->

<!--  Bootstrap 최신 버전의 CSS 파일들을 링크 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- jQuery 최신 버전의 js파일들을 링크 (bootstrap의 js전에) -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script> <!-- 스크립트는 반드시 닫는 스크립트 따로 넣어줘야 함 -->

<!-- Bootstrap을 이용하기 위한 최신 버전의 js 파일들을 링크(js파일을 링크하는데에 jQuery가 필요) -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>

<title>JSP</title>
</head>
<body>

	<h1>메인 페이지</h1>
	<c:if test="${not empty userid}">
	<%-- userid 속성이 null이 아니고, 빈 문자열("")도 아닌 경우: 로그인 --%>
		${userid}님, 환영합니다@~<br/>
		<a href="logout" class="btn btn-warning">로그아웃</a>
	</c:if> 
	
	<c:if test="${empty userid}">
	<%-- 로그아웃 상태 --%>
		<a href="login" class="btn btn-success">로그인</a>
	</c:if>
	<hr/>
	
	<h2>여기는 본문입니ㅏㄷ..</h2>

</body>
</html>