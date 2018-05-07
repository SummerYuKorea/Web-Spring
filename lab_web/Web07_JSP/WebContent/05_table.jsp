<%@page import="edu.web1.contact.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style>
	table, th, td{
		border: 1px solid grey;
		border-collapse: collapse;
	}
</style>
</head>
<body>

	<h1>Scriptlet을 사용한 테이블 작성</h1>
	
	<table>
		<thead>
		
			<tr>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
			</tr>
		
		</thead>
		
		<tbody>
			<tr>
				<td>유한결</td>
				<td>010-6341-1490</td>
				<td>rufgksdb@naver.com</td>
			</tr>
			<tr>
				<td>오쌤</td>
				<td>010-2222-3333</td>
				<td>ohssam@itwill.com</td>
			</tr>
			<tr>
				<td>관리자</td>
				<td>010-7777-7777</td>
				<td>manager@itwill.com</td>			
			</tr>
		</tbody>
	<%-- 정적으로 할때는 이케 되지. 근데 DB에서 받아와서 테이블에 뿌리거나 할 때는? --%>
	</table>
	
	<hr/>
	
	<%
	//ArrayList 선언, 생성
	ArrayList<Contact> contacts=new ArrayList<>();  //자동완성이 쫌 달라~
	contacts.add(new Contact("일도1","010-4613-9326","godpeach2@hanmail.net"));
	contacts.add(new Contact("일도2","010-4613-9326","godpeach22@hanmail.net"));
	contacts.add(new Contact("일도3","010-4613-9326","godpeach222@hanmail.net"));
	
	
	%>
	
	<table>
		<thead>
			<tr>
				<th>이름</th>
				<th>전화번호</th>
				<th>이메일</th>
			</tr>
		
		</thead>
		
		<tbody>
			<% //scriptlet시작!
			for(int i=0;i<contacts.size();i++){%>
				<tr>
					<td><%=contacts.get(i).getName()%></td>
					<td><%=contacts.get(i).getPhone()%></td>
					<td><%=contacts.get(i).getEmail()%></td>
			<%}//for %>
		</tbody>
	</table>
	

</body>
</html>