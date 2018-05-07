<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>회원 가입 페이지</h1><br/><br/>
	
	<form action="insert" method="post">
		<label>아이디</label><br/>
		<input name="userid" placeholder="ID입력"/><br/><br/>
		<label>비밀번호</label><br/>
		<input name="userpw" placeholder="PW 입력"/><br/>
		<input  placeholder="PW 확인"/><br/><br/>
		<label>이메일</label><br/>
		<input name="email" placeholder="EMAIL입력"/><br/><br/>
		
		<input type="submit" value="회원 가입 하기"><br/>
	</form>

</body>
</html>