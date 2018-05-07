<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원 리스트</h1>
	
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이메일</th>
				<th>계정 활성</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${memberList}" var="vo">
			<tr>
				<td><a href="detail?userid=${vo.userid }">${vo.userid }</a></td>
				<td>***********</td>
				<td>${vo.email }</td>
				<td>${vo.active }</td>
			</tr>
			</c:forEach>
			
		</tbody>
	</table>

</body>
</html>