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

	<h1>jQuery Ajax post() 함수</h1>
	<input type="text" placeholder="ID" id="userid"/>
	<input type="password" placeholder="PASSWORD" id="userpw"/>
	<button type="button" id="btn" >제출</button>
	<div id="result">결과아</div>

	<script>
		$(document).ready(function(){
			$('#btn').click(function(){
				var data={ //json object 형태로 줘야함 ~(ㅇㅎ?)
						id: $('#userid').val(),
						pw: $('#userpw').val()
				};
				$.post('ajax_test.jsp', data, 
						function(res,status,xhr){ //비동기방식으로(언제돌아올지모름) 응답이 돌아왔을 때 그 응답을 처리하는 callback 함수
					if(status==='success'){
						$('#result').html(res); 
					}
					
				});
			});
		});
		
		/*
		jQuery Ajax post()함수
		$.post(url, data, callback)
		
		callback=function(res, status, xhr){}
		*/
	</script>
</body>
</html>