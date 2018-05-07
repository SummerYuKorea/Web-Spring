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

	<h1>댓글 페이지</h1>
	<div>
		<input type="text" id="rtext"placeholder="댓글을 입력해세여"/>
		<input type="text" id="replier" placeholder="아이디"/>
		<button type="button" id="btn_add">작성</button>
	</div><hr/>
	
	<div id="replies">
	</div>
	
	<script>
	$(document).ready(function(){
		var bno=1;
		getAllReplies(); //전체리스트보내주세요
		function getAllReplies(){
			//$.get(url, callback)
			//$.getJSON(url, data, callback)
			//		url: 서버의 요청 주소
			//		data: 요청과 함께 보낼 데이터(선택)
			//		callback: JSON 데이터가 리턴되었을 때 처리할 함수
			var url= '/ex03/replies/all/'+bno;   //restAPI방식
			$.getJSON(url,function(jsonData){   
				//get방식의 ajax 요청을 보내는 중// 저 url로 //그럼 저 주소를 처리할 수 있는 RestController는 ResponseEntity<List>를 리턴
				//그 리턴값이 json으로 감싸져서 불린 콜백함수의 매개변수로 들어가는듯
				console.log(jsonData.length);//데이터 온 것 확인하려고~
				
				var list='';
				
				//for(var i=0;i<jsonData.length;i++){  //랑 밑ㄴ에랑 똑같ㅇㄷ능거야~
				$(jsonData).each(function(){ //each: for문 만드는 함수임 for문써도되는데
					var date = new Date(this.regdate);  //array의 첫번째 원소가 function을 호출 했을 때의 this.(x번째 원소)
					var dateString = date.toLocaleDateString();
					console.log(dateString);
					list+='<div class="reply_item">'+'<input type="hidden" value="'+this.rno+' "/>' + '<input type="text" id="rtext" value="'+this.rtext+'"/><br/>'
						+'<input type="text" id="replier" value="'+this.replier+'" readonly/><br/>'+dateString+'<br/>'+
						'<button class="btn_update" type="button">수정</button>'
						+'<button class="btn_delete" type="button">삭제</button>'+'</div><hr/>'
				});
				
				$('#replies').html(list);
			});
		}
	});
	</script>

</body>
</html>