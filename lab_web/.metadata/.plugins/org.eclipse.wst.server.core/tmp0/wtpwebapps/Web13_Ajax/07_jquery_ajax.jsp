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

	<h1>jQuery Ajax의 ajax() 함수</h1>
	<input type="text" placeholder="ID" id="userid"/>
	<input type="password" placeholder="PASSWORD" id="userpw"/><br/>
	<button type="button" id="btn_get" >get 방식 제출</button>
	<button type="button" id="btn_post" >post 방식 제출</button>
	<div id="result">결과아</div>
	
	<script>
		$(document).ready(function(){
			$('#btn_get').click(function(){
				$.ajax({  //ajax는 object를 하나 넘겨주면됨 //and object 요소는 다음과 같음
					type: 'get',
					url: 'ajax_test.jsp?id='+$('#userid').val()+'&pw='+$('#userpw').val(),
					success: function(res, status, xhr){ //성공했을 떄 실행할 함수.(success라는 property가 따로 있음)
						$('#result').html(res);	
					}
				});
			});
			
			$('#btn_post').click(function(){
				$.ajax({
					type: 'post',
					url: 'ajax_test.jsp',
					data: {
						id: $('#userid').val(),
						pw: $('#userpw').val()
					},
					success: function(res, status, xhr){ //성공했을 떄 실행할 함수.(success라는 property가 따로 있음)
							$('#result').html(res);	
					}
				});
			});
		});
	</script>
</body>
</html>