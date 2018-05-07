<%@page import="edu.web.model.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>

	<h1>EL(Expression Language)</h1>
	<h2>EL 자료 타입</h2>
	
	<%-- 숫자, 문자열, 논리형, 객체(Set, List, Map, ...) --%>
		${n=100 }<br/> <!-- n이라는 변수를 선언, 값넣은것 -->
		n=${n}<br/>
		<%-- EL은 문자열을 사용할 때 큰따옴표(""), 작은따옴표('') 모두 사용 가능 --%>
		이름: ${name="오쌤"}<br/>
		<%--계산이가능! 식~임// false반환--%>
		${1==2}<br/><hr/>
	
	<%-- EL Set : {e1, e2, e3,...}  =>Java의 HashSet<Object>와 비슷 --%>
		<%--자바에서    Set은 집합같은거// 중복 허용x, 순서 없음
				   Map은 key-value 조합! --%>
		${set = {1.2, 100, "hi", true, 1.2 }} <br/>	<!-- 순서뒤죽박죽됨! -->
	
	<%-- EL List: [e1, e2, e3,...]  =>Java의 ArrayList<Object>에 해당 --%>
		${list = [1.2, 100, "hi", true, 1.2 ]} <br/>	
		${list[1] }<br/>
		
	<%-- EL Map: {k1:v1, k2:v2, ...} =>Java의 HashMap<Object, Object>에 해당--%>
		${map= {"한결이":"천재","일도":"멍청이",3:"three", 'key':list}}<br/> <!-- key, value에 어떤 타입이 와도 상관 x -->
		${map["한결이"]}<br/>
		${map[3]}<br/><hr/>
		
	<h2>EL 연산자</h2>
	${1+2*3/4}<br/>
	${1 eq 2}<br/> <!-- eq, == 이 두개는 같은 연산자 -->
	${1 ne 2}<br/> <!-- ne, != 이 두개는 같은 연산자 not equal (EL에서 자꾸 빨간줄 뜨는건 이클립스 버그)-->
	${1 div 2}<br/> <!-- div, /   EL은 정수실수를 구분ㅇ하지않기때문에 몫이아니라 그냥나눗셈계산이라는사실~-->
	${1 mod 2}<br/> <!-- mod, % -->
	<%-- lt(<), gt(>)  less than이랑 greater than이라능 --%>
	<%-- le(<=), ge(>=) less or equal이라는 뜻~--%>
	<%-- and(&&), or(||), not(!) --%>
	<%-- 삼항연산자:  (식)? 값1:값2 --%>
	${123>0?"양수":"음수 또는 0~"}<br/>
	${123 gt 0?"양수":"음수 또는 0~"}<br/><hr/>
	
	<h2>EL에서 객체(Object) 사용</h2>
	<!-- 겍체는 어쩔수없어~ java로 Contact클래스 만들고 옴 -->
	<%
	//form에서 넘어온 값들을 넣어서 모델클래스의 생성자를 부름->  서블릿에서?ㅇㅇ
	Contact c1=new Contact("오쌤","010-1111-2222","ohssam@itwill.com");
	request.setAttribute("contact1", c1); //request에 우리가 만든 객체 넣기
	//request말고 다른것들도쓸수잇ㅇ으나. 일단 request배웟으니까 req에 속성주자 key-value로~
	
	//jsp에서 할일?
	Contact c=(Contact)request.getAttribute("contact1");
	out.write("이름:"+c.getName()+"<br/>");
	
	%>
	jsp에서 할 두줄이 EL에서는?<br/>
	이름:${contact1.name}<br/> <!-- Attribute의 key값에서 바로 받아온다는 듯?(알아서찾아옴)//사실은내부적으로getter메소드를알아서불러줌// EL을 쓰는 이유래 -->
	전번:${contact1.phone}<br/> <!-- 근데 getter가 딱 getPhone()같은 방식이 아니면 못찾아온대// PropertyNotFoundException(프로퍼티=필드=멤버변수) -->
	이멜:${contact1['email'] } <!-- Map에서 Attribute 읽어오는 방법이랑 같져 -->
	
	<%--EL은 내장객체의 Attribute로 설정이 되어있는 객체에 직접 접근할수가 있다!!!!!!!! 변수이름으로 접근!!!!!!! 
		
		EL은 JSP의 지역변수는 직접 접근 불가 - 단점 
		JSP의 내장 객체(request, pageContext, session,...)의 attribute는 접근가능!
		내장 객체의 attribute에 저장된 타입이 객체(object)이면,
		그 멤버 변수들은 변수 이름만으로 접근 가능(getter메소드가 standard한 방법으로 잘 만들어져 있어야 한다~) 
		
		
		C:\Program Files\Apache Software Foundation\Tomcat 8.0\bin에가서 shutdown.bat실행하면 서버가 강제로 죽음
		<- 서버 재시작이 잘 안될때! 포트 충돌날때(제대로 종료가 안되었다는 얘기)--%>
		
		<%--그래서 환경변수에서 pass에 저 경로를 설정해놓으면
		cmd가서 바로 shutdown.bat해서 죽일 수 있다.(섬뜩!)
		--%>
		
	<hr/>
	<h2>EL에서 람다표현식 사용하기</h2>
	<%-- (x,y,...) -> {실행문;} --%>
	${( (x,y)->(x+y) ) (1,200)}<br/> <!-- 이거는 람다표현식을 쓴다음 그걸 괄호로 묶어서 함수로 만든것 then 매개변수 1,200을 줌!// 함수를 만들고 호출까지 바로 해버림 -->
	${add=(x,y)->x*y}<br/> <!-- add에 람다표현식 저장! add가 함수가 된것. 메소드의 저장 주소가 뜸(메소드 영역)-->
	${add(2,33)}<br/>

</body>
</html>