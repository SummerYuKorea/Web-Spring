<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8"/>
<title>File Upload</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<!-- 2017.05.15 월 -->

<h1>파일 업로드 양식</h1>
<h2>단일 파일 업로드만 테스트 해보기</h2>

<form action="upload" method="post" enctype="multipart/form-data">
	<input type="file" name="file"/>
	<input type="submit" value="업로드" />
</form>

<!--  
1) form 양식의 input을 통해 파일을 전송하는 방법

multipart는 서버에서 쪼개진 패킷들을 처리해야 한다는 뜻이다. enctype을 꼭 변경해줘야 한다. 
이것을 위해 commons-fileupload라는 라이브러리를 추가했던 것이다. 
-->



<h2>다중 파일 업로드</h2>

<form action="upload2" method="post" enctype="multipart/form-data">

	<!--  
	파일 선택 창에서 여러 파일을 동시에 선택 
	multiple 속성을 주면 된다. 
	-->
	<input type="file" name="files" multiple />
	<input type="submit" value="업로드" />

</form>











<script>
$(document).ready(function(){
	
	if(${not empty savedFile}){
		alert('${savedFile} 저장 성공');
	}
	
});
</script>

</body>
</html>




















