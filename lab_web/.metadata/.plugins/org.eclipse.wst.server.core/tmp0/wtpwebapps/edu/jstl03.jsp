<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL03</title>
</head>
<body>

<%--

	[3] Function Tag
		:자주 사용하는 유틸 함수 기능 제공
		
		
	fn:contains(string, sbustring)	: 	string이 substring을 포함하면 return True
	fn:containsIgnoreCase(string, sbustring)	: 	대소문자 관계없이 string이 substring을 포함하면 return True
	fn:endsWith(string, suffix)	: 	string이 suffix로 끝나면 return True
	fn:escapeXml(string)	: 	stting에 XML과 HTML에서 특수문자(<,>,&,',")들이 있으면, XML엔티티 코드로 바꿔준뒤 문자열 반환
	fn:indexOf(string, sbustring)	: 	string에서 substring이 처음으로 나타나는 인덱스 반환
	fn:join(array, separator)	: 	array요소들을 separator를 구분자로 하여 연결해서 반환
	fn:length(item)	: 	item이 배열이나 컬렉션이면 요소의 객수를 문자열이면 문자의 객수를 반환
	fn:replace(string, before, after)	: 	string내에 있는 before 문자열을 after 문자열로 모두 변경해서 반환
	fn:split(string, separator)	: 	string내의 문자열 separetor에 따라 나누어서 배열로 구성해서 반환
	fn:startsWith(string, prefix)	: 	string이 prefix로 시작하면 return True
	fn:substring(string, begin, end)	: 	string에서 begin인덱스에서 시작해서 end인덱스에 끝나는 부분의 문자열 반환
	fn:substringAfter(string, sbustring)	: 	string에서 substring이 나타나는 이후의 문자열 반환
	fn:substringBefore(string, sbustring)	: 	string에서 substring이 나타나는 이전의 문자열 반환
	fn:toLowerCase(string)	: 	 모두 소문자로 바꿔 리턴
	fn:toUpperCase(string)	: 	 모두 대문자로 바꿔 리턴
	fn:trim(string)	: 	앞뒤의 공백을 모두 제거하여 반환
	fn:join(array, str2) :  array에 저장된 문자열을 합침, 각 문자열의 사이에는 str2가 붙음

		
 --%>
 
 
<%--  
    <c:set var="name" value=" Nexen heroes 베이스볼클럽 "/>
    <p>name: ${fn:replace(name, ' ', '*')}</p>
    <c:set var="name" value="${fn:trim(name)}"/>
    <p>trim name: ${fn:replace(name, ' ', '*')}</p>

    <p>length(name): ${fn:length(name)}</p>
    <p>toUpperCase(name): ${fn:toUpperCase(name)}</p>
    <p>toLowerCase(name): ${fn:toLowerCase(name)}</p>
    <p>substring(name,3,6): ${fn:substring(name,3,6)}</p>
    <p>substringBefore(name,'heroes'): ${fn:substringBefore(name, 'heroes')}</p>
    <p>substringAfter(name,'heroes'): ${fn:substringAfter(name, 'heroes')}</p>
    <p>replace(name, '베이스볼클럽', 'BaseballClub'): ${fn:replace(name, '베이스볼클럽', 'BaseballClub')}</p>
    <p>indexOf(name, 'heroes'): ${fn:indexOf(name,'heroes')}</p>
    <p>contains(name, 'Nexen'): ${fn:contains(name, 'Nexen')}</p>
    <p>containsIgnoreCase(name, 'nexen'): ${fn:containsIgnoreCase(name, 'Nexen')}</p>
    <p>startsWith(name, 'Nex'): ${fn:startsWith(name, 'Nex')}</p>
    <p>startsWith(name, 'heroes'): ${fn:startsWith(name, 'heroes')}</p>
    <p>endsWith(name, '베이스볼클럽'): ${fn:endsWith(name, '베이스볼클럽')}</p>
    <c:remove var="name"/>
--%>
  
    
<%--     
    <c:set var="willit" value="김선, 김재, 유, 이, 최"/>
    <c:set var="arr" value="${fn:split(willit,',')}"/>
    <c:forEach var="name" items="${arr}">
        ${name}<br/>
    </c:forEach>
    <p>join : ${fn:join(arr, ',')}</p>

 --%>

</body>
</html>