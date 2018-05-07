<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pageContext</title>
</head>
<body>

<%-- 	<%
		/////////////PageContext의 메소드
		
		//기능1: 요청을 재지정
		pageContext.forward("relativeUrlPath"); //지정된 페이지로 이동
		pageContext.include("relativeUrlPath"); //현재 JSP 문서에 포함
		
		//기능2: 내장 객체를 반환
		pageContext.getException();
		pageContext.getPage();
		pageContext.getRequest();
		pageContext.getResponse();
		pageContext.getServletConfig();
		pageContext.getServletContext();
		pageContext.getSession();
	%> --%>
	
	
	
	

	<%!
		public void work(String param, PageContext pageContext) {
			JspWriter out = pageContext.getOut(); //*
			
			try {
				
				if (param.equals("include")) {
					
					out.print("-- include 전 -- <br>");
					pageContext.include("heroes.jsp");
					out.print("-- include 후 -- <br>");
					
				} else if (param.equals("forward")) {
					
					pageContext.forward("heroes.jsp");
					
				}
			
			
			} catch(Exception e) {
				System.out.println("오류 발생"+ e.getMessage());
			}
		}
	
		// 내장 객체를 매개변수로 넘겨줘서 사용하기
		public String dd(HttpServletRequest req){
			System.out.println(req.toString());
			return "";
		}
	%>
	
	<%
		String param = request.getParameter("param");
		this.work(param, pageContext);
		dd(request);
		System.out.println(request.toString());
	%>
	
</body>
</html>