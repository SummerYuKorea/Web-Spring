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

	<h1>XMLHttpRequest GET 방식 요청</h1>
	<input type="text" placeholder="아이디" id="userid"/>
	<input type="password" placeholder="비밀번호" id="userpw"/>
	<button type="button" id="btn" >Ajax 전송</button> 
	<div id="result"></div>
	
	<script>
		$(document).ready(function(){
			$('#btn').click(function(){ ///버튼 눌러도 위에 주소가 안바뀌는 것을 볼 수 있<- Ajax방식
				var id=$('#userid').val(); //value읽어오는 jQuery함수
				var pw=$('#userpw').val();
				var url='ajax_test.jsp?id='+id+'&pw='+pw;  //GET방식!!
				
				var xhr=new XMLHttpRequest();
				xhr.open('GET',url,true);
				xhr.send();
				
				xhr.onreadystatechange = function(){
					if(xhr.readyState===4 && xhr.status===200){//4:응답이 끗났단얘기~
						$('#result').html(xhr.responseText);	//ajax_test.jsp의 내용이 responseText로 들어오는것
					}
					if(xhr.status===404)console.log('페이지 못 찾았어요..');		
				};
			});
			
		});
	</script>

</body>
</html>