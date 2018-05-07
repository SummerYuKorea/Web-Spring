<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>새글 작성 페이쥐</h1><hr/>
	
	<form action="" method="post">
		<input type="text" name="title" required autofocus placeholder="제목 입력"/><br/>
		<textarea rows="5" cols="40" name="content" placeholder="본문 작성" required ></textarea><br/>
		<input type="text" name="userid" placeholder="아이디" required/><br/>
		<input type="submit" value="작성완ㄱ료">
	</form>

</body>
</html>