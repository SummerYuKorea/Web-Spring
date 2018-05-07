<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

<%--	JSP 내장 객체:
	JSP 파일이 서블릿 클래스로 변환됐을 때
	_jspService() 메소드가 가지고 있는 지역 변수들
	ex)  request, response, session, application, page,..
 --%>
 
<%! //선언문(Declaration): 멤버 변수, 메소드, 내부 클래스
	private static final String ADMIN_ID="admin";
	private static final String ADMIN_PW="1234";

%>
	
	<h1></h1>
<% //요청 파라미터(request parameter)의 값들을 읽어옴
	String id=request.getParameter("id");  //내장객체이용해서 가져옴
	String passwd=request.getParameter("passwd");
	System.out.println("ID:"+id);
	System.out.println("PASSWD:"+passwd);
	
	
	//DB 연결, 아이디/패스워드 일치 체스, 체크 결과에 따라서 해당 페이지 로드
	if(id.equals(ADMIN_ID) && passwd.equals(ADMIN_PW)){
		//로그인 성공
		//out.write("로그인 성공했어요~");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("mainPageForLoginSuccess.jsp");
		//dispatcher.forward(request, response);
		//근데이렇게하면 주소가 loginCheck그대로임 bad
		
		response.sendRedirect("mainPageForLoginSuccess.jsp?id="+id);
		//이렇게하면 redirect로 가도 id 읽어올수있다. 주소줄 main으로 바꾸면서도 id넘겨주는꼼수// redirect는 get과 post방식이 모두 가능하다
		
	}else{
		//로그인 실패
		response.sendRedirect("07_loginForm.jsp?id="+id+"&login=wrong");
		
	}
%>

</body>
</html>