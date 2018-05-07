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

	<h1>XMLHttpRequest Post방식 요청</h1>
	<input type="text" placeholder="ID" id="userid"/>
	<input type="password" placeholder="PW" id="userpw"/>
	<button type="button" id="btn">Ajax Post 요청</button>
	<div id="result"></div>
	
	
	<script>
		$(document).ready(function(){
			$('#btn').click(function(){
				var id=$('#userid').val();
				var pw=$('#userpw').val();
				
				var xhr = new XMLHttpRequest();
				xhr.open('POST','ajax_test.jsp',true); //post는 query string을 추가할 수가 없지
				
				// POST 방식에서는 요청 헤더 정보 설정이 필요
				xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); 
					//->헤더 안에 contentType이라는 속성에 저런값 주는중
				
					// POST 방식으로 보낼 데이터 설정 (request의 body에 들어갈 내용)
				var data = "id="+id+"&pw="+pw; //데이터를 JSON 오브젝트로 만들 수도 있지(그땐 ContentType이 바뀌면 됨)
					
				// send(data) 메세지 호출 - 요청 전송
				xhr.send(data);
				
				//응답 처리를 할 수 있는 핸들러 함수 등록
				xhr.onreadystatechange = function(){
					if(xhr.readyState === 4 && xhr.status === 200){
						$('#result').html(xhr.responseText); 
						//post방식에서는 id나 pw가 한글일경우 깨지겠지. request의 body부분은 encoding이 utf-8이 아니니까
					}
				};
			});
		});
		
		
	</script>
	

</body>
</html>