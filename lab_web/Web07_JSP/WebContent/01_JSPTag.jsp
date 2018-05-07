<%@page import="java.util.Date"%> <%--Directive 지시자!! 클래스 밖 내용적는곳인듯// page 디렉티브의 import속성 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <!-- 이부분은 client로 전달이 되지 않음. 왜냐하면 jsp는 결국 servlet으로 변환되어 클래스가 생기고 거기서 써주기 때문에
    	jsp파일을 열려고 요청했을때 개발자도구를 열어서 써지는 내용을 보면 html태그만 써지고 jsp태그는 써지지 않음
    	자바스크립트는 브라우져가 실행시키는애. jsp태그는 서버!!에서 실행되는 거!! 그래서 개발자도구에 안보임!!
    							
    	jsp파일이 servlet클래스로 변환이 되면
    	->C:\Study\lab-web\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\web07\org\apache\jsp
    	에 있는 _01_005fJSPTag_jsp.java파일로 자동으로 변환되어 있는것을 확인할 수 있음
    	카탈리나는 톰캣에서 쓰는 폴더이름임.신기
    	C:\Study\lab-web\.metadata\.plugins\org.eclipse.wst.server.core(이클립스가 실행하는 가상서버)
    	(여기 들어와보면 톰캣 프로그램폴더밑에 구조와 똑같음)
     -->
     
 <%--
 JSP 동작 원리:
 1. 런타임 시에 JSP 컴파일러에 의해서 JSP 파일(.jsp)이 자바 파일(.java)로 변환
 	=>이 자바파일은 서블릿클래스!
 2. 자바 컴파일러가 자바 파일을 컴파일해서 클래스파일(.class)을 생성
 3. JRE이 클래스 파일을 CPU가 이해할수 있는 기계어로 번역해서 실행
 	=> 요청(request), 응답(response)을 처리
  --%>
  
  
  
<%--JSP 주석
  JSP 구성요소(Tag)
  1. <%@  %> : Directive(지시자)
  			  JSP 페이지 전체에 대한 속성들을 설정
  2. <%!  %> : Declaration(선언문)
  			   멤버 변수, 메소드, 내부 클래스를 선언하는 부분	(여기서 선언한 변수는 멤버변수)
  3. <%   %> : Scriptlet(스크립틀릿)
  			   메소드(_jspService) 내부에서 실행되는 자바 코드를 작성하는 부분	(여기서 선언한 변수는 지역변수가 되는것)	 
  4. <%=  %> : Expression(표현식)
  			   변수의 값, 메소드의 리턴 값 등을 프린트
  5. Comment(주석).지금쓰고잇는이거~ 
  				//이 주석(<%-- %>)은 kind of jsp의 주석이야 jsp의 것은 무조건 개발자도구에서 볼수없음. 이주석은 안보임 신기!! 
  				//<!-- -->은 HTML, XML주석은 브라우져 개발자도구에서 볼 수 있지(로직에대한 설명들은 jsp나 java주석으로 다는게 좋지 그니까~)
  			  //이 jsp주석은 클래스로 변환될 때도 들어가지 않음. 
  			  //단 Scriptlet이나 Declaration내부에서 자바코드 작성할 때 쓰는 '//'같은 자바주석은 java파일에 다 같이 들어감~
  			  
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>JSP Tag(구성 요소)</h1>
	<%-- Declaration(선언문) --%>
	<%! public int add(int x, int y){
			return x+y;
	}
	%>
	
	<%-- Scriptlet --%>
	<%	
		//지역변수선언
		int result= add(10,20);
	
		//JSP에서 출력 방법
		// 1) console 로그
		System.out.println("result: "+result);
		
		// 2) Writer 객체를 사용해서 응답(response)으로 출력
			//_jspService메소드내에 들어갈 코드이므로 out사용(Servlet에서처럼 response.getWriter()을 호출하면 안되져~)
			//근데이거쓰면JSP를쓰는 의미가없겠져~
		out.write("<p>result="+result+"<p>\r\n"); 
	%>
	
	<%-- Expression(표현식) --%>
	<p>결과값: <%=result %></p>
	
	
	<%
	Date date=new Date();
	
	//////밑에 Servers 탭(?) 가서 더블클릭하면 설정내용이 나오는데 그게 server.xml의 내용이야 거기보면 한 서버안에 모듈단위로 각프로젝트가 나누어져 있는것을 볼 수 있음
				//server.xml은 Project Explorer에서 Servers 밑에 있음.
		// 거기가서보면 내가 여기서 서버를 시작해도 Web01_프로젝트부터 차례로 load가 되는 설정을 확인, 편집할수도있음 .
		// 서버에서의 모듈이란 프로젝트 단위로 나누어져 있음.
		// 많은 모듈을 한서버(한WAS)가 관리하는 것은 안드로이드에서 전화번호부도 있고 카메라도 있고 문자도 있고 하는것을 전체 안드로이드가 관리하고 있는거랑 비슷한.
	%>
	

</body>
</html>

