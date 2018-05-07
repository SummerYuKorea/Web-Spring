<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- 실제 이런식으로 쓴다!///프로젝트에 해야지~ --%>
<c:set var="lang" value="${not empty param.lang? 
						param.lang : pageContext.request.locale}" />
			<%--not empty는 null도아니고 비어있는 문자열도 아니라는뜻 --%> 
			<%--각 브라우져는 서버로 request를 보낼때 locale이라는 프로퍼티에 내 언어설정을 같이 보내줘 ./항상~
				그래서 formatDate같은 거에서도 브라우져의 설정 따라서 서버가 보내주는 값이 달라질 수 있었던것(!!!)
				개발자도구->network->All->Headers에서 보내주는값 확인 가능하다 --%>
<fmt:setLocale value="${lang}"/>
			<%--이렇게하면. 내가 locale을 설정해주면 그 로케일로. 내가 설정하지 않을 경우 브라우져에서 보내온 로케일로 
				내가 설정하는 경우는 var에 set해줄수도 있겠지만
				주소에 ?lang=ko_KR  하고 붙여주기만해도 번역이되어버리는것! 신기?--%>
<fmt:setBundle basename="edu.web2.i18n.login_bundle"/>
			<%--그냥 bundle은 내가 필요한 부분만 묶어서 쓸때 //setBundle은 파일 전체에 --%>
			
		<%--http://localhost:8181/web09/14_setBundle.jsp?lang=zh_CN라고 보내면 중국어가 뜨는거지 --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>&lt;fmt:setBundle&gt;</h1>
	
	<form>
		<label ><fmt:message key="login.bundle.id"/></label>
		<input type="text" name="userid"/><br/>
		<label><fmt:message key="login.bundle.pw"/></label>
		<input type="password" name="pwd"/><br/>
		<fmt:message key="login.bundle.login" var="btn_login"></fmt:message>
		<input type="submit" value="${btn_login}"/>
	</form>

</body>
</html>