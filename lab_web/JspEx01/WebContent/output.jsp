<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
</head>
<body>
<%-- 
	<% if(request.getMethod().equals("POST")) { %> --%>
	
		
	<%
			/////////////request, response
			// HttpServletRequest, HttpServletResponse
			// 요청, 응답 정보 처리
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			
			
			
			
			
			
			
			
			/////////////session
			// HttpSession
			// 클라이언트 단위로 정보 유지시 사용
			/* if (session.isNew() || session.getAttribute("id")==null) {
				session.setAttribute("id", "me");
				out.print("로그인 완료");
			} else {
				out.print("이미 로그인 상태");
			} */
		
		
	%>
	
	<%= id %> / <%= pwd %>
	
	<%-- <%
		} else if(request.getMethod().equals("GET")) {
			
			if(session != null && session.getAttribute("id") != null) {
				session.invalidate();
				out.print("로그아웃 완료");
			} else {
				out.print("현재 로그인 상태가 아님");
			}
		}
	
	%> --%>

</body>
</html>