<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

	<h1>Scriptlet 연습</h1>
	<%-- Scriptlet 안에서 for문을 사용해서 --%>
	
	<table>
		<thead>
			<tr>
				<th>2단</th>
				<th>3단</th>
				<th>4단</th>
			</tr>
		</thead>
		
		<tbody>
		<%for(int i=1;i<10;i++){ %>
			<tr>
			<% for(int j=2;j<5;j++){%>
				<td><%=i*j %></td>
			<%}//for작은거 %>
			</tr>
		<%}//for큰거 %>
			
		</tbody>
	</table>

</body>
</html>