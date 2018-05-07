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

	<h1>jQuery Ajax load() 함수</h1>
	<button type="button" id="btn1">클릭1</button>
	<button type="button" id="btn2">클릭2</button>
	
	<div id="result">버튼 클릭하먄 여기 내용이 바뀔거야 봐봐뿅</div>
	
	<script>
		$(document).ready(function(){
			$('#btn1').click(function(){
				$('#result').load('test.txt'); //jQuery방식으로 요청을 보내고 요청을 보내준 element에다가 돌아온 response를 직접 써주기까지.
											 //load는 get방식으로만 사용됨
			});
			
			$('#btn2').click(function(){
				$('#result').load('test11.txt #para1', function(res,status,xhr){//test파일에서 #para1을 찾는 것
					if(status === 'success'){
						alert("성공: "+res);
					}else if(status==='error'){
						alert('에러: '+xhr.status); //xhr.status는 404,500,200(은 success지만) 같은 에러코드가지고있지
						//url 이상하게 적으면 못찾겠다고 error나지
					}else{
						alert('HTTP code: '+xhr.status);
					}
				}); //이거 보면 url이 load되기 전에 먼저 callback 함수를 실행하는것을 볼수있
			});		//res(response)로는 test.txt의 내용이 다 넘어온다. 후에 load라는 함수가 그 중 para1을 찾는 것
		});
		
		/*
		jQuery Ajax load() 함수:  
			//data나 callback을 구지 만들지 않고 이미지 한개 불러오거나 할 때 주로 씀
		
		$('선택자').load(url, data, callback)
			url로 Ajax 요청을 data와 함께 보내고,
			응답을 받았을 때 '선택자'로 선택된 요소에 응답 내용을 load함
		-url : 서버로 요청할 주소(html, jsp, url mapping, image, ...)
		-data: 요청과 함께 서버로 보내는 데이터(생략 가능)
		-callback: 서버에서 응답이 왔을 때 실행될 콜백 함수(리스너)
		
		callback(response, status, xhr)
		-response: load()호출이 성공했을 때 서버로부터 보내지는 텍스트
		-status: load() 호출 상태에 대한 텍스트('success', 'error')
		-xhr: XMLHttpRequest 객체
		
		*/
	</script>
	
</body>
</html>