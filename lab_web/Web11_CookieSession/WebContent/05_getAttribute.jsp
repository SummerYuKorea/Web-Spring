<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>세션 정보 확인</h1>
<%
	String id1=(String)request.getAttribute("id"); //object를 리턴한다 request의 attribute엔 object형태 다넣을 수 있으므로
	String id2=(String)session.getAttribute("id");
	
	out.println("request의 id: "+id1+"<br/>");  //null반납
	out.println("session의 id: "+id2+"<br/>"); 	//admin_session 잘 나옴
	
	//  forward까지는 request가 같아.주소줄이 같기때문에// redirect는 request유지 안됨
	// 하나의 주소가 유지가 되는 경우는 request객체가 유지가 됨.
	// 04->05로 주소바뀜->리퀘스트도 바뀌었지. 
%>

</body>
</html>