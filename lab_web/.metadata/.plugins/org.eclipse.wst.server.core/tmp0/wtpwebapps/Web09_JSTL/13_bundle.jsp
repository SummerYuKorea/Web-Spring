<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>&lt;fmt:bundle&gt;와 &lt;fmt:message&gt;</h1>
<%--
	I18N(Internalization, 국제화): 
		전세계의 언어를 지원할 수 있도록 SW를 제작하는것
	L10N(Localization, 지역화):
		해당 지역의 언어로 SW를 번역하는것
	
	웹 애플리케이션에서 I18N, L10N을 지원하는 방법:
	1) 리소스 파일을 작성하고 자바 패키지에 포함(자바파일이 아님에도 불구하고//리소스파일이 classes(나중에컴파일되었을때의폴더)에 들어가야하기때문)
		:파일이름_로케일.properties
	2) <fmt:bundle> 태그의 basename 속성에 리소스 파일 이름을 설정.
	3) <fmt:message> 태그의 key 속성에 사용할 문자열 키를 지정
--%>

<fmt:setLocale value="zh_CN"/>
	<!-- 이렇게보내면 basename에 뒤에 붙여서 파일을 찾는거야 //login_bundle_zh_CN라는식으로
		 로케일의 value값은 이미 브라우져에서(리퀘스트에실어서) 보낸값이 들어있다.
		 그래서 setLocale하지않아도 어떤 value를 붙여서 실행을 하게되는데
		 해당 파일을 못찾을 경우 아무런 로케일이 붙어있지않은 default 형태인 login_bundle///내의 key-value값을 실행하게됨 
		 그래서 선생님의 경우에는 브라우져에서 ko라고만(언어코드는빠지고) 보내지고 있었는데
		 그경우에는 해당파일을 못찾았기 때문에! 디폴트파일인 영어해석이 실행되었던것
		 왜 ko라고만 보내는지는 모름~
		 이럴경우엔 똑같은 한국어 파일을 login_bundle_ko.properties라고만해서 저장해놓자-->
<fmt:bundle basename="edu.web2.i18n.login_bundle">
	<form>
		<label ><fmt:message key="login.bundle.id"/></label>
		<input type="text" name="userid"/><br/>
		<label><fmt:message key="login.bundle.pw"/></label>
		<input type="password" name="pwd"/><br/>
		<fmt:message key="login.bundle.login" var="btn_login"></fmt:message>
		<input type="submit" value="${btn_login}"/>
	</form>
</fmt:bundle>

</body>
</html>