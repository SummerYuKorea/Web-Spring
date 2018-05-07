<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

<h1>회원 수정 페이지</h1><br/><br/>
	
	<form action="update" method="post" >
		<label>아이디</label><br/>
		<input name="userid"  value="${vo.userid }" readonly /><br/><br/>
		<label>비밀번호</label><br/>
		<input name="userpw" value="${vo.userpw }" /><br/>
		<label>이메일</label><br/>
		<input name="email" value="${vo.email }" /><br/><br/>
		<input type="submit" value="수정 완료"/>
	</form>
	
</body>
</html>