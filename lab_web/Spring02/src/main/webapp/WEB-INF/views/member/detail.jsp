<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>JSP</title>
</head>
<body>

<h1>회원 정보 페이지</h1><br/><br/>
	
	<form id="frm">
		<label>아이디</label><br/>
		<input name="userid" value="${vo.userid }" readonly/><br/><br/>
		<label>비밀번호</label><br/>
		<input name="userpw" value="${vo.userpw }" readonly/><br/>
		<label>이메일</label><br/>
		<input name="email" value="${vo.email }" readonly/><br/><br/>
	</form>
	
	<button id="btn_update">수정</button>
	<button id="btn_delete">탈퇴</button>
	
	<script>
	$(document).ready(function(){
		var frm=$('#frm');
		$('#btn_update').click(function(){
			frm.attr('action', 'update');
			frm.submit();
		});
		
		$('#btn_delete').click(function(){
			frm.attr('action','delete');
			frm.submit();
		});
	});
	</script>

</body>
</html>