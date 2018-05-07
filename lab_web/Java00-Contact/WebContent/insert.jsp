<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="dicePoker.dicePokerDAO"%>

<%
	dicePokerDAO dao = dicePokerDAO.getInstance();
	String userId = request.getParameter("userId");
	String passWd = request.getParameter("passWd");
	dao.insert(userId, passWd);
	System.out.print("회원가입 실행");
%>