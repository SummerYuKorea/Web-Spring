<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL02</title>
</head>
<body>

<%--
	[2] Format Tag
		:국제화와 포맷팅을 지원
		
		
		1.<fmt:setLocale> :국제화 태그들이 사용할 로케일 지정
		
			<fmt:setLocale value="언어코드[_국가코드]" scope="page|request|session|application" />



		2.<fmt:formatNumber> :숫자의 형식을 특정 포맷으로 표현
			<fmt:formatNumber value="numericValue"
					        [type="{number|currency|percent}"] 숫자|통화|퍼센트
					        [pattern="customPattern"] 사용자가 지정한 형식 패턴
					        [var="varName"]
					        [scope="{page|request|session|application}"]/>
					        
					        
		3.<fmt:parseNumber/> :문자열에서 숫자를 파싱
			<fmt:parseNumber [type="{number|currency|percent}"]
					        [pattern="customPattern"]
					        [parseLocale="parseLocale"]
					        [integerOnly="{true|false}"] 주어진 값에서 Integer 부분만 파싱할 지 여부
					        [var="varName"]
					        [scope="{page|request|session|application}"]>	
					        
      	4.<fmt:formatDate/>	:날짜와 시간 형식 표현		
		
 --%>
 
<fmt:setLocale value="ko_KR"/>
 
<p>number  : <fmt:formatNumber value="1234567.89" type="number"/></p>
<p>currency : <fmt:formatNumber value="1234567.89" type="currency" currencySymbol="￦" /> </p>
<p>percent : <fmt:formatNumber type="percent">0.159</fmt:formatNumber></p>
<p>pattern=".000"    :<fmt:formatNumber value="1234567.1" pattern=".000" /></p>
<p>pattern="#,#00.0#":<fmt:formatNumber value="1234567.891" pattern="#,#00.0#"/></p>


<p>number  : <fmt:parseNumber value="1,234,567.89" type="number"/></p>
<p>currency : <fmt:parseNumber value="12345abcdef" integerOnly="false" type="number" /></p> 

<h6>===============================</h6>

<c:set var="now" value="<%=new Date()%>" />

<p> date full : <fmt:formatDate value="${now}" type="date" dateStyle="full" /></p>
<p> date short : <fmt:formatDate value="${now}" type="date" dateStyle="short" /></p>
<p> time : <fmt:formatDate value="${now}" type="time" /></p>
<p> both full : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /></p>
<p> pattern 1 : <fmt:formatDate value="${now}" pattern="yyyy-MM-dd aa hh:mm:ss" /></p>
<p> pattern 2 : <fmt:formatDate value="${now}" pattern="yyyy-MM-dd  hh:mm:ss" /></p> 


</body>
</html>