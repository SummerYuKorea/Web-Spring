<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP의 스크립트 Example</title>
</head>
<body>
	<h1>Script Example</h1>
	
	<%!
		String declaration = "선언문 Declaration";
	%>
	<%!
		public String decMethod() {
			return declaration;
		}
	%>
	
	<%
		String scriptlet = "스크립틀릿 Scriptlet";
		String comment = "주석 Comment";
		out.println("내장객체를 이용한 출력 : " + declaration + "<br>");
	%>
	
	선언문의 출력 1: <%=declaration %><br>
	선언문의 출력 2: <%=decMethod() %><br>
	스크립트릿의 출력 : <%=scriptlet %><br>
	
	<!-- JSP의 주석 -->
	<!-- HTML 주석: <%=comment %> --><br>
	<%-- JSP 주석: <%=comment %> --%><br>
	<%
		/*
			JAVA 주석
			(여러 줄 주석)
		*/
	
		// JAVA 주석 (한 줄 주석)
		

		
		///////////// 주석으로 처리되는 시점
		//	JSP 주석: 서블릿 코드로 변환될 때
		//	HTML 주석: 클라이언트에 의해 응답이 파싱될 때
		//	JAVA 주석: 서블릿 소스가 컴파일될 때
	%>
	
	
	<%
		
		///////////// 선언문
		// JSP 페이지 내의 스크립트 코드에서 사용할 멤버변수 선언/ 메소드 정의할 때 (선언만 함)
		// 실행되려면 _jspService() 메소드 내에 있어야 함 -> 스크립트릿, 표현식으로 호출
	
		///////////// 스크립트릿
		// JSP 페이지가 요청될 때마다 수행되어야 하는 자바코드를 추가할 때 사용
		// 태그 사이의 코드는 자바소스로 변환시 _jspService() 메소드 내로 그대로 옯겨짐
		
		///////////// 표현식
		// 동적인 데이터를 응답 결과에 포함할 때 사용
		// _jspService() 메소드 내에 out.print(); 로 변환됨
		
		///////////// 지시자
		// 지시자 속성 = 값
		// JSP 컨테이너가 JSP 페이지를 파싱해 자바 소스로 변환하는 데 필요한 정보 제공
		// page, taglib, include 등
	
		///////////// JSP 작성시 주의 사항
		// 중첩 태그를 허용하지 않음 
		
	%>


</body>
</html>