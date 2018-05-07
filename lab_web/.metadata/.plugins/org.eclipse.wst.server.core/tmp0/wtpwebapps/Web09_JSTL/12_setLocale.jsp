<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>&lt;fmt:setLocale&gt;</h1>
<%--
	Locale: 해당 국가에서 사용하는 언어를 설정(언어코드_국가코드)
	ko_KR: 한국어_대한민국
	en_US: 영어_미국
	en_GB(Greate Britain): 영어_영국
	ja_JP: 일본어_일본
	zh_CN:중국어_중국(간체, simplified Chinese)
	zh_CN:중국어_중국(번체, traditional Chinese)
	de_DE:독일어_독일
--%>
	<h3>미국식~</h3>
	<fmt:setLocale value="en_US"/>
	<fmt:formatNumber value="123456789.123456"></fmt:formatNumber><br/>
	<fmt:formatNumber value="10000" type="currency"></fmt:formatNumber><br/>
	<c:set var="now" value="<%=new Date() %>"/>
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br/><br/>
	
	<h3>영국식~</h3>
	<fmt:setLocale value="en_GB"/>
	<fmt:formatNumber value="123456789.123456"></fmt:formatNumber><br/>
	<fmt:formatNumber value="10000" type="currency"></fmt:formatNumber><br/>
	<c:set var="now" value="<%=new Date() %>"/>
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br/><br/>
	
	<h3>니뽄식</h3>
	<fmt:setLocale value="ja_JP"/>
	<fmt:formatNumber value="123456789.123456"></fmt:formatNumber><br/>
	<fmt:formatNumber value="10000" type="currency"></fmt:formatNumber><br/>
	<c:set var="now" value="<%=new Date() %>"/>
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br/><br/>
	
	<h3>중국식</h3>
	<fmt:setLocale value="zh_CN"/>
	<fmt:formatNumber value="123456789.123456"></fmt:formatNumber><br/>
	<fmt:formatNumber value="10000" type="currency"></fmt:formatNumber><br/>
	<c:set var="now" value="<%=new Date() %>"/>
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br/><br/>
	
	<h3>독일식</h3>
	<fmt:setLocale value="de_DE"/>
	<fmt:formatNumber value="123456789.123456"></fmt:formatNumber><br/>
	<fmt:formatNumber value="10000" type="currency"></fmt:formatNumber><br/>
	<c:set var="now" value="<%=new Date() %>"/>
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br/><br/>

</body>
</html>