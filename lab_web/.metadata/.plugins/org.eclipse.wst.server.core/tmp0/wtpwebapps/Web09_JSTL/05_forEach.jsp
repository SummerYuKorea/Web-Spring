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

	<h1>&lt;c:forEach&gt;</h1>
	
<%	for(int i=0;i<=10;i++){%>
	<%=i %><br/>	<%--이거 대괄호 없이 안되네???물음표 --%>
<%} %><hr/>

	<c:forEach begin="1" end="10" var="num"> <%--위랑 똑같은 형태! //var에 변수이름으로 넣은 효과 --%>
		${num }<br/>
	</c:forEach><hr/>
	
		<c:forEach begin="2" end="10" var="num" step="2" varStatus="status"> 
		${status.index},${num }<br/> <%--그냥 두개가 똑같네!! index랑 num --%>
	</c:forEach><hr/>
	
<%
	String[] movies= {"Abc","Def","Ghi"};
%>
	<ul>
		<%for(String m:movies){ %>
		<li><%=m %></li>
		<%} %>
	</ul><hr/>
	
	<ul>
		<c:forEach var="movies" items="<%=movies%>">
			<%--items안에 EL로 ${movies} 할수있?-> 당근 없지 movies는 _jspService의 지역변수야 Attribute가 아니라
			위에서   <c:set var="movieList" value="<%=movies%> scope="request"> 넣어주면 movieList로 EL쓸 수 있겠지! --%>
			<li>${movie }</li><%--이건 되지 var에 넣었잖아 --%>
		</c:forEach>
	</ul>

</body>
</html>