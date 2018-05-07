<%-- <%@page import="java.io.PrintWriter"%> --%>
<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="dicePoker.dicePokerDAO"%>
<%@page import="dicePoker.dicePokerVO"%>

<%
	dicePokerDAO dao = dicePokerDAO.getInstance();

	String userId = request.getParameter("userId");
	String passWd = request.getParameter("passWd");
	dicePokerVO vo = dao.select(userId, passWd);
	
	if (vo == null) {
		response.getWriter().print("empty");
	}
%>