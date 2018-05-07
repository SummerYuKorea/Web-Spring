<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>&lt;c:catch&gt; 태그</h1>
	<c:catch var="error">
		예외 발생 전<br/>
		계산1: ${123/0}<br/> <%--EL은 무조건 실수의 계산으로 해버려서 에러가 안남! infinity뜸 --%>
		계산2: <%=123/0 %><br/> <%--자바는 자료형에대해 엄격해. 정수면 500에러나버림~ java.lang.ArithmeticException: / by zero --%>
		출력이 될까요?<br/>
	</c:catch>
	
	에러내용:${error}<br/> <%--계산2: 라고까지만 출력됨!신기~ --%>

</body>
</html>