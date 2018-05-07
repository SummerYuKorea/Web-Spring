<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JavaBeans</title>
</head>
<body>
	<h3>자바빈즈를 사용하는 표준 액션 태그</h3>
	
	
	<!-- Hero hero = new Hero() -->
	<jsp:useBean id="hero" class="kr.willit.beans.Hero" scope="page"/>
	<jsp:useBean id="hero2" class="kr.willit.beans.Hero" scope="page"/>
	
	<!-- hero.setName("andy"); -->
	<jsp:setProperty property="name" name="hero" value="Andy"/>
	
	<!-- hero.getName(); -->
	<jsp:getProperty property="name" name="hero"/>
	
<!-- 	<form action="javaBeans2.jsp" method="post">
	    Name : <input type="text" name="name"/><br/>
	    Level : <input type="text" name="level" /><br/>
        <input type="submit" value="SUBMIT" />
    </form> -->
    
    
    
    
    <%
    	/////////<jsp:useBean>
    	// id: 유일한 값
    	// class: 자바빈즈 객체의 실제 클래스명을 패키지명과 함께 지정
    	// type: 접근할 타입 지정.(부모타입 등) -생략시 클래스 타입
    	// scope: page | request | session | application
    	//		page: 하나의 JSP 페이지내에서만 사용
    	//		request: 요청이 처리되는 동안 forward, include된 페이지 간에 사용
    	//		session: 클라이언트(브라우저) 단위로 사용
    	//		application: 웹 애플리케이션 단위로 사용 (서버 종료/ 애플리케이션 삭제될 때까지 상주)
    	
    	
    	/////////<jsp:getProperty>
    	// name: useBean 태그에서 정의한 id 속성값과 동일
    	// property: 자바빈즈 객체의 멤버변수 이름을 지정
    	
    	
    	/////////<jsp:setProperty>
    	// name, property
    	// value: 자바빈즈 객체의 속성을 변경하려는 값
    	// param: 쿼리스트링에서 param 속성에 할당된 값과 같은 name의 값
    	//		hero.setName(request.getParameter("param"));
    	// property="*" : 객체의 모든 setter 메소드를 호출
    %>



</body>
</html>