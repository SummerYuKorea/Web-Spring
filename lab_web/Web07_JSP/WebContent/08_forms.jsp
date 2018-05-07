<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>여러가지 Form 양식</h1>
	<form action="08_result.jsp" method="post">
		<input type="text" name="user_name" placeholder="이름" required autofocus/><br/>
		<input type="number" name="user_age" placeholder="나이"/><br/>
		
		<!-- radio는 하나의 값만 넘어갈수있음 -->
		<input type="radio" name="mail_receive" value="accept" id="mail_accept" checked="checked"/>
		<label for="mail_accept">수신동의</label>  <!-- for속성 주면 레이블을 체크해도 라디오input이 반응하지 -->
		<input type="radio" name="mail_receive" value="deny" id="mail_deny"/><!-- value를 줘야 name에 대응하는 값이 넘어가지 -->
		<label for="mail_deny">수신거부</label><br/>
		
		<!-- checkbox는 여러개값 넘어갈수있음(배열) -->
		<input type="checkbox" name="hobby" value="movie" id="ch_movie"/>
		<label for="ch_movie">영화</label> 
		<input type="checkbox" name="hobby" value="music" id="ch_music"/>
		<label for="ch_music">음악</label> 
		<input type="checkbox" name="hobby" value="swimming" id="ch_swimming"/>
		<label for="ch_swimming">수영</label><br/>
		
		<select name="email"><!-- 이 drop-down-list는 하나만 선택이되는 형태(여러개되는것도있음) -->
			<option value="none" selected disabled>------</option> <!-- selected:얘가 보이는 상태에서 시작(checked같은) -->
			<option value="@hanmail.net">다음</option>
			<option value="@naver.com">네이버</option>
			<option value="@gmail.com">구글</option>
		</select><br/>
		
		<!-- input type이 text나 number일 때 아무것도 입력안하고 action페이지(submit후)로 넘어가면
			널이아니라 빈문자열이 queryString으로 넘어가는것을 확인할 수 있다
			
			하지만 radioButton이랑 checkBox는 선택 하지않으면 아예 name도 넘어가지 않아!!
			넘어간 페이지에서 radio랑 check에관한 parameter다룰때(request.getParameter 할때) null check가 필수적이라는것-->
		
		
		<input type="submit" value="제출" />
		<input type="reset"  value="취소"/>
		
	</form>
	
	

</body>
</html>