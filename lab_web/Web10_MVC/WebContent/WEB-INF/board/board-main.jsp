<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 모바일 디바이스에서 터치줌 등을 지원하기 위해서  -->
<meta name="viewport" content="width=device-width, initial-scale=1"/><!-- 1:기본줌레벨  을 쓰겠다 -->

<!--  Bootstrap 최신 버전의 CSS 파일들을 링크 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- jQuery 최신 버전의 js파일들을 링크 (bootstrap의 js전에) -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script> <!-- 스크립트는 반드시 닫는 스크립트 따로 넣어줘야 함 -->

<!-- Bootstrap을 이용하기 위한 최신 버전의 js 파일들을 링크(js파일을 링크하는데에 jQuery가 필요) -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>

<title>JSP</title>

<style >
	h1{
		font-weight: bold;
		
	}
</style>

</head>
<body>

<div class="container">
	<h1>게시판 메인 페이지</h1><br/>
	<%--이거 실행하면 404에러가 나오는게 정상
		WEB-INF 밑에 두면 숨겨두는거야 / 서버 외부에서는 접속할 수 없도록 막아놓은 폴더
		브라우져에서 파일 이름을 알더라도 주소 쳐서 접속할 수가 없다.
		이름을 알아도 볼 수 없게끔 일부러 넣어두는 경우들이 있다.
		
		지금경우에는 모든 REQUEST가 controller를 통해서 View(JSP)에 접근할 수 있도록 하려는것
		forward로 접근해서 들어올거야 
		
		생성된 JSP도 결국 compile되어야 사용되는거 알지?
		HTML형태로 compile이 되어서 그게 reponse로 넘어가는거야.(!!새삼새로운것..//아 response.getWriter에 write하는거~)-> 그럼 브라우져에 뜨는거임 --%>
		
	<!--  c:if test="${empty loginStatus}"> -->
	<c:if test="${empty userid}">
		<ul class="breadcrumb">
			<li><a class="btn btn-info" href="member-insert">회원 가입</a></li>
			<li><a class="btn btn-primary" href="member-login">로그인</a></li>
			<li><a class="btn btn-warning" href="board-insert">새 글 작성</a></li>
			<%--이렇게 주면 http://localhost:8181/web10/board-insert 로 이동함 --%>
		
		</ul>
	</c:if>
		
	<!--  c:if test="${loginStatus eq 'login'}">-->
	<c:if test="${not empty userid}">
		${userid }님 환영합니당~
		<ul>
			<li><a class="btn btn-info" href="member-delete">탈퇴</a></li>
			<li><a class="btn btn-primary" href="member-logout">로그아웃</a></li>
			<li><a class="btn btn-warning" href="board-insert">새 글 작성</a></li>
		
		</ul>
	</c:if>
	
	<hr/>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성시간</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${boardList}">
				<tr>
					<td>${vo.bno }</td>
					<td><a href="board-detail?bno=${vo.bno}">${vo.title }</a></td>
					<td>${vo.userid }</td>
					<td>
						<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
</div>
</body>
</html>