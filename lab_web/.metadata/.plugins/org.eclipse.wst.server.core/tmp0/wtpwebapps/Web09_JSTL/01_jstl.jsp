<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	

<%--
	1) JSTL 라이브러리를 프로젝트에 추가: WebContent/WEB-INF/lib/taglib-1.2.x.jar
	2) JSP 파일에서 JSTL 라이브러리를 사용하겠다고 선언: <%@ taglib prefix="" uri="" %> 지시자(directive)를 사용
	3) JSTL 기능들: core(c), format(fmt), ...(xml, sql, function(fn) 은 안권장)
 --%>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <!-- c는 core기능 (내가 c라고 부르겠다고 정해준것)//uri의 저주소안에  if나 out등의 tag들의 spec이 저장되어 있는데 그걸 간단히 c라고 부르겠다(name space)-->
 
	<h1>JSTL(Java Standard Tab Library): 표준 태그(를 사용하는) 라이브러리</h1>
 	<c:out value="Hello, JSTL!"></c:out><br/><!-- c에있는 out을 이용하겠다(out: print인듯) -->
 	<!-- 위같은 이런 태그를 만나는 순간 서버에서 얘를 자바코드로 변환해주는 것(jsp가 servlet이 될 떄) -->
 	
 	${'Hello, EL!'}<br/>
 	
 	<!-- JSTL과 EL의 차이점
 		""안에 <br/>같은 태그가 들어갔을 경우 EL에서는 HTML으로받아들려처리. out에서는 그냥 문자열 -->
</body>
</html>