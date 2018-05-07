<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>브라우저가 보낸 쿠키 확인</h1>
	<%-- 요청(request)에 실려서 서버로 전송된 쿠키 확인 --%>
	
<%
	Cookie[] cookies=request.getCookies();
	for(Cookie c: cookies){
		String name=c.getName(); //쿠키 이름
		String value=c.getValue();//쿠키 값
		out.println(name + " : " + value + "<br/>");
	}
	
	
	
%>

	<a href="03_expireCookie.jsp">쿠키 userid 삭제</a>

</body>
</html>