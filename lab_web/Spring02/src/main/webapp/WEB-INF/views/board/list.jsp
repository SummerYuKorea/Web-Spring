<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<title>JSP</title>

<style>
	ul{
		list-style-type: none;
	}
	
	li{
		display: inline-block;
	}
</style>
</head>
<body>

	<h1>게시판 메인 페이지</h1><hr/>
	
	<ul>
		<li><a href="register">새 글 작성</a>  </li>
		<!-- URL 상대path  : 현재 JSP가 있는 폴더 위치에서 상대적인 경로  
								 href="register" :  http://localhost:8181/ex02/board/register로 이동함 
			   URL 절대path  :  서버 주소에서 시작하는 경로
			   					href="/register":  http://localhost:8181/register로 이동    (심지어 context root도 없음)
			   JSP내에서 경로를 쓰려면 주의해야된대-->
			   
		<li><a href="/ex02/member/insert">신규 회원 가입</a></li>
		<li><a href="/ex02/member/list">회원 리스트</a></li>
	</ul>
	
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>글쓴이</th>
				<th>날짜</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${boardList }" var="vo">
			<tr>
				<td>${vo.bno }</td>
				<%-- <td><a href="detail?bno=${vo.bno}">${vo.title }</a></td> --%>
				<td><a href="${vo.bno}" class="goToDetail">${vo.title }</a></td>
				<td>${vo.userid }</td>
				<fmt:formatDate value="${vo.regdate}" var="regdate" pattern="yyyy-MM-dd HH:mm:ss"/>
				<td>${regdate }</td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
	
	<ul class="pagination">
		<c:if test="${pageMaker.hasPrev }">
		<li><a href="${pageMaker.startPageNo -1 }">이전</a></li></c:if>
		
		<c:forEach begin="${pageMaker.startPageNo }" end="${pageMaker.endPageNo}" var="num">
		<li><a href="${num }">${num}</a></li>
		</c:forEach>
		
		<c:if test="${pageMaker.hasNext }">
		<li><a href="${pageMaker.endPageNo +1 }">다음</a></li></c:if>
	</ul>
	
	<form id="pagingForm" style="display:none;">
		<input type="text" name="page" value="${pageMaker.criteria.page }"/>
		<input type="text" name="perPage" value="7"/><%-- ${pageMaker.criteria.numsPerPage}"/> --%>
		
		<input type="text" name="bno" />
	</form>
	
<script>

$(document).ready(function(){

	$('.pagination li a').click(function(){
		//a 태그의 기본 동작(페이지 이동)을 금지
		event.preventDefault();
		var targetPage=$(this).attr('href');  //this는 클릭한 element(a 태그)
		
		var frm= $('#pagingForm');
		frm.find('[name="page"]').val(targetPage);
		frm.attr('action','list');
		frm.attr('method','get');
		frm.submit();
		
	});
	
	//디테일 페이지 까지도 page랑 perPage 전달해주려고 script로 따로 빼서 처리하는중
	$('.goToDetail').click(function(){
		event.preventDefault();
		var bno=$(this).attr('href');
		
		var frm=$('#pagingForm');
		frm.attr('action', 'detail');
		frm.attr('method', 'get');
		frm.find('[name="bno"]').val(bno);
		frm.submit();
		
	});
	
	if ('${insert_result}' === 'success') {
		alert('새 글 작성 성공');
	} else if ('${insert_result}' === 'fail') {
		alert('새 글 작성 실패');
	}
	
});
</script>

</body>
</html>