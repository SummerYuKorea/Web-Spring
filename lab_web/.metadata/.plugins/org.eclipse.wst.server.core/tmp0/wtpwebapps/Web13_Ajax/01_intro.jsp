<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CDN 추가 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style>
	div{
		width:400px;
		height:200px;
		margin:10px;
		border: 1px solid grey;
		
	}
</style>
<title>JSP</title>
</head>
<body>

	<h1>Ajax: Asynchronous JavaScript (And XML)</h1>
	<h2>자바스크립트를 사용한 비동기 통신 방식</h2>
	<button id="btn">클릭</button>
	<div id="result"></div>
	<div id="log"></div>
	
	<script>
$(document).ready(function(){ //HTML 렌더링이 다 끝난 후 실행하겠따
		/* Ajax 사용 순서:
		1. 클라이언트(브라우저)
			1) XMLHttpRequest 객체 생성 -> 서버로 전송
			2) 서버에서 처리된 response를 처리할 수 있는 함수(이벤트 핸들러)를 등록
		2. 서버
			1) XMLHttpRequest를 처리 -> HttpResponse 객체 생성
			2) 응답(response)을 클라이언트로 전송
		3. 클라이언트(브라우저)
			1) 서버에서 전송된 데이터를 등록한 함수를 통해서 처리
			2) 화면(페이지) 업데이트
		*/
		
	$('#btn').click(function(){
		
		// XMLHttpRequest 객체 생성
		var xhr =new XMLHttpRequest();
			
		// 요청 open(get/post, 서버 리소스 주소, true(비동기므로 무조건 true))
		xhr.open('GET','test.txt',true)//서버(파일)의 위치(꼭 jsp나 servlet일 필요가 없음 가지고 있는 어떤ㄴ 리소스던간에)
				//test.txt 보내주세요 라는 요청
		
		// 요청 전송
		xhr.send();
		
	
		
		// 서버에서 이벤트/응답이 왔을 때 처리할 이벤트 핸들러 함수 등록
		xhr.onreadystatechange = function(){
			var readyState= xhr.readyState;
			var log =$('#log'); 
			var msg = log.html(); //text: 태그와 태그사이에 있는 text만 가져오는것
			
			switch(readyState){
			case 0: msg +='요청 초기화 이전<br/>';console.log('0');break;
			case 1: msg +='서버와 연결됨<br/>';console.log('1');break;
			case 2: msg +='서버가 요청을 받음<br/>';console.log('2');break;
			case 3: msg +='서버에서 요청 처리중<br/>';console.log('3');break;
			case 4: msg +='요청 처리 끝/응답 사용 가능<br/>';console.log('4');break;
			}
			
			/*0: request not initialized
			● 1: server connection established
			● 2: request received
			● 3: processiong request
			● 4: request finished and response is ready
			*/
			
			log.html(msg);
			
			var result=$('#result');
			if(readyState===4 && xhr.status === 200){
				result.html(xhr.responseText);
			}
		};//onReadyStateChange의 이벤트 펑션
		
	});//버튼 클릭했을때
});
	</script>

</body>
</html>