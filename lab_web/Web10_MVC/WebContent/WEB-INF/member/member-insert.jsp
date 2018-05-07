<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<div class="container">
	<h1>회원가입 페이지</h1>
	<form action="member-insert" method="post">  <!-- insert에 post로 보내면 doPost쓸수있지. -->
		<label for="userid">아이디   </label>
		<input type="text" name="userid" id="userid"  required="required"/><br/>
		<label for="userpw">비밀번호</label>
		<input type="password" name="userpw" id="userpw" required/><br/>
		<label for="email">이메일   </label>
		<input type="email" name="email" id="email" required/><br/>
		
		<input class="btn btn-default btn-lg" type="submit" value="가입 완료"
				style="margin:10px"/>
	</form> 
</div>
</body>
</html>