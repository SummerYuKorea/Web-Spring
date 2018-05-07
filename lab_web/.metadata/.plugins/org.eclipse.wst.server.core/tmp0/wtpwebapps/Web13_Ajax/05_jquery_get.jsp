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

	<h1>jQuery Ajax get()함수</h1>
	<button type="button" id="btn1">클릭1</button><br/>
	<input type="text" placeholder="ID" id="userid"/>
	<input type="password" placeholder="PASSWD" id="userpw"/>
	<button type="button" id="btn2">클릭2</button><br/>
	
	<div id="result">버튼 클릭하먄 여기 내용이 바뀔거야 봐봐뿅</div>
	
	<script>
		$(document).ready(function(){
			$('#btn1').click(function(){
				$.get('test.txt', function(res, status, xhr){
					if(status==='success'){
						$('#result').html(res);	
					}
				}); 
			});
			
			$('#btn2').click(function(){
				// ajax_test.jsp?id=xxx&pw=yyy
				var url = 'ajax_test.jsp?id='
					+ $('#userid').val()
					+ '&pw='
					+ $('#userpw').val();
				$.get(url,
						function(res, status, xhr){
					if(status==='success'){
						$('#result').html(res);
					}
				});
			});
		});
		
		/*
		jQuery Ajax get():
		$.get(url, callback) 
			get에서는 url에 data가 같이 넘어가므로 data매개변수가 필요 없(load도 get방식이라며?)
			get은 selector를 쓸필요(element 안찾음)가 없어 load와 달리
			보내겠다~ 가 끝// element에 쓰려면 callback함수 내에서 다 해줘야해
		
		callback(response, status, xhr){}  //load랑 same	
		*/
	</script>

</body>
</html>