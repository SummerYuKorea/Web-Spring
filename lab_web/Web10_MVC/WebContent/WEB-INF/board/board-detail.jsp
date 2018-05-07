<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
</head>
<body>
<div class="container">
	<h1>게시글 상세 보기</h1><%--여기는 readonly 페이지 --%>
	<ul class="breadcrumb">
		<li><a class="btn btn-info" href="board-main">전체목록</a></li>
		<li><a class="btn btn-success" href="board-update?bno=${boardVO.bno}">수정</a></li>  
		<%--수정눌렀을때 (나중에session까지 생각해서) 지금이거 누른 사용자와 로그인한 사용자가 같으 경우만 수정이 가능하도록. 하기위해 controller와 JSP새로따로만들것--%>
	</ul>

	<hr/>
<form>
	<label for="title">글 제목</label><br/>	
	<input type="text" id="title" name="title" value="${boardVO.title }" readonly /><br/>
	
	<label for="content">글 내용</label><br/>
	<textarea rows="5" cols="40" id="content" name="content" readonly>${boardVO.content}</textarea><br/>
	
	<label for="userid">작성자 아이디</label><br/>
	<input type="text" id="userid" name="userid" value="${boardVO.userid }" readonly /><br/>
	
	<label for="regdate">작성 시간</label><br/>
	<fmt:formatDate var="regdate" value="${boardVO.regdate }" pattern="yyyy-MM-dd HH:mm" />
	<input type="text" id="regdate" name="regdate" value="${regdate }" readonly /><br/>
</form>
</div>
</body>
</html>