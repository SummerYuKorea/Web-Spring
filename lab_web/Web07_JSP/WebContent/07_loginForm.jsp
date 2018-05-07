<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%-- page 지시자(directive)에서 contentType속성을 설정하는 것은
    	response.setContectType("text/html; charset=UTF-8");
    	을 호출하는것과동일.(서블릿에서)
    	or
    	response.setContectType("text/html");
    	response.setCharacterEncoding("UTF-8"); 두 문장과 동일
    	
    	pageEncoding 속성을 설정하는 것은
    	response.setCharacterEncoding("UTF-8");을 호출하는 것과 동일
    	그래서 contentType설정하면 이건 not necessary
    	
    	html형식으로 response로 보낼때에는 contentType만 저렇게 설정해도 UTF-8됨
    	근데 가령 json Object같은 거를 response로 보낼수도 있지
    	그럼 contentType에서 html을 바꿔줘야겠지
    	
    	language속성도 구지 자바로주는거 not necessary
    	어차피자바밖에안됨 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

<%--
1. Ctrl + Space : 입력 보조장치(Content Assistance) 강제 호출 => 입력하는 도중엔 언제라도 강제 호출 가능하다.
2. F2 : 컴파일 에러의 빨간줄에 커서를 갖져다가 이 키를 누르면 에러의 원인에 대한 힌트를 제공한다.
3. Ctrl + l : 원하는 소스 라인으로 이동
  로컬 히스토리 기능을 이용하면 이전에 편집했던 내용으로 변환이 가능하다.
4. Ctrl + Shift + Space : 메소드의 가로안에 커서를 놓고 이 키를 누르면 파라미터 타입 힌트를 볼 수 있다.
5. 한줄 삭제 CTRL + D
6. 파일 닫기 : CTRL+W 
7. 들여쓰기 자동 수정. (3.0 NEW) : CTRL+I 
8. 블록 주석(/*..*/) 추가.(3.0 NEW): CTRL+SHIFT+/ 
  8.1 Ctrl + / 해주면 여러줄이 한꺼번에 주석처리됨. 주석 해제하려면 반대로 하면 됨.
9. 위(아래)줄과 바꾸기 : ALT+UP(DOWN) 
10. 블록 선택하기.  : ALT+SHIFT+방향키 
11. 메소드의 파라메터 목록 보기. : CTRL+SHIFT+SPACE
12. 자동으로 import 하기 : CTRL+SHIFT+O 
13. 열린 파일 모두 닫기 : CTRL + SHIFT + F4
14. 블록 주석 제거 : CTRL+SHIFT+
15. 전체화면 토글 : CTRL+M 
16. 한줄(블럭) 복사 : Ctrl + Alt + 위(아래) 
17. 다음 annotation(에러, 워닝, 북마크 가능)으로 점프 : Ctrl + , or . 
18. 퀵 픽스 : Ctrl + 1  
19. 메소드 정의부로 이동 : F3
20. 하이어라키 팦업 창 띄우기(인터페이스 구현 클래스간 이동시 편리) : Ctrl + T  
21. 메소드나 필드 이동하기 CTRL + O 
22. ULTRAEDIT나 EDITPLUS 의 CTRL+TAB 과 같은 기능. : CTRL+F6
 --%>
 
 <%
 String id=request.getParameter("id");
 String login=request.getParameter("login");
 if(login!=null&&login.equals("wrong"))%><script>alert("아이디나 비번이 틀렸습니당")</script>
 
 
 
 <!-- 이것좀봐봐랑!! 헷갈리기 시작~ -->
 

	<h1>로그인 양식</h1>
	<form action="loginCheck.jsp" method="post"><!-- 로그인은 포스트방식 이용햐져 -->
		<input type="text" name="id" placeholder="ID"
			<%if(id!=null){%>value="<%=id%>"<%} %>
			required/><br/> <!-- required 속성 주면 비어있을때 submit버튼이 동작 안함 -->
		<input type="password" name="passwd" placeholder="PASSWORD"/><br/><br/>
		<input type="submit" value="로그인~"/>
	</form>
	
	

</body>
</html>