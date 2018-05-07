<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8"/>
<title>File Upload</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
.file-drop{
	width: 100%;
	height: 200px;
	border: 1px solid grey;

}
</style>

</head>
<body>

<h1> Ajax를 이용한 파일 업로드 </h1>	
	
<div class="file-drop"></div>	
<div class="upload-list"></div>
<%System.out.println("2. upload-ajax.jsp 실행"); %>


<script>
 $(document).ready(function(){
	 // 파일을 끌어다 놓을 때 (drag & drop)
	 // 브라우저가 파일을 자동으로 열어주는 기능을 막음 (기본적으로 브라우저가 동작을 한다.)
	 
	 
	 
	 $('.file-drop').on('dragenter dragover', function(event) {
		 event.preventDefault();		 
	 });
	 
	 //drop 부분에서 한 가지 동작을 더 추가할 것이다. ajax 방식으로 파일을 업로드 하는 기능까지 추가!
	 $('.file-drop').on('drop', function(event){
		 
		 // drop 이벤트의 기본 동작을 막음
		 event.preventDefault();
		 
		 // Ajax를 이용해서 서버로 파일을 업로드
		 // multipart/form-data 타입으로 파일을 업로드하기 위해서 
		 var formData = new FormData();
		 
		 // drop한 파일들에 대한 정보 가져오기.
		 var files = event.originalEvent.dataTransfer.files;
		 var i = 0;
		 for (i = 0; i < files.length; i++){
			 console.log(files[i]);
		 
			 // 이제 이 파일 정보들을 formData에 넣는다. 서버에 보내기 위해서임.
			 // 'files' 라는 이름으로 모든 파일들을 append 하기 
			formData.append('files', files[i]);
			 
			 // formData가 완성이 되었으니, 서버로 보내기.
			 // 제이쿼리 라이브러리가 포함되어있어야 $ 포함된 함수 쓸 수 있음! 에이작스!
			 
			 
		 	$.ajax({
		 		type: 'post',
		 		url: '/ex05/upload-ajax',
		 		data: formData, 
		 		dataType: 'text',
		 		processData: false,
		 		contentType: false,
		 		/* 
		 		form의 enctype 속성을 기본값인 "application/x-www-form-urlencoded"을 사용하지 않고,
		 		"multipart/form-data"를 사용하기 위해서 반드시 주어야 할 속성은
		 		dataType: text, processData, contentType: false
		 		
		 		processType: true이면 enctype이 기본값이 되기 때문에 반드시 false라고 주어야 한다.
		 		*/
		 		success: function(data){
		 			alert(data);
		 			
		 			var str = $('.upload-list').html(); //이렇게 하면 파일이 밑에 계속 추가될 것.
		 			str += '<div>' 
		 					+ '<img src= "display?fileName='
		 					+ data
		 					+ ' "/>'
		 					+ data
		 					+ '</div>';
		 			$('.upload-list').html(str);	 					
		 						 					
		 		} //end success
		 	}); //end ajax
		 	
		 }//end for(i)
		
		
		 
		 
	 });
	 
	 
 });
</script>



</body>
</html>



















