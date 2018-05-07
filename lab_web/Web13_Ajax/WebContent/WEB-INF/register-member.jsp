<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>JSP</title>
</head>
<body>

	<h1>회원가입 양식</h1>

	<form action="register-member" method="post">
		<input type="text" placeholder="ID" id="userid" name="userid" required autofocus/>
		<div id="result"></div><br/>
		<input type="password" placeholder="PASSWD" id="userpw" name="userpw" required /><br/>
		<input type="email" placeholder="EMAIL" id="email" name="email" required /><br/>
		<input type="submit" id="btn-submit" value="회원가입"/><br/>
	</form>
	
	<script>
		$(document).ready(function(){
			$('#userid').keyup(function(){  //키 눌럿다 뗐을 때
				$.ajax({
					type:"post",
					url:'check-id',
					data: {
						userid:$('#userid').val()
					},
					success:function(res, status, xhr){  //브라우져는 response를 받았을 때 다음 함수를 실행시킴
						var result=$('#result');
						if(res==='valid'){
							result.html('멋진 아이디야');
							result.css('color','green');
							$('#btn-submit').prop('disabled',false);//property중에 disabled라는 prop을 false로 바꾸겠다
							//required, autofocus, disabled등이 property지 //나머진 attribute(attr)
						}else{										
							result.html('사용할 수 없는 아이디~')
							result.css('color','red');
							$('#btn-submit').prop('disabled',true); //submit 버튼 안눌리도록
						}
					}
				});
			});
		});
	</script>
</body>
</html>