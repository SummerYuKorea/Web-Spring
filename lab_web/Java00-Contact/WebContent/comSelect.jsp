<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="dicePoker.dicePokerDAO"%>
<%@page import="dicePoker.dicePokerVO"%>
<%@page import="com.google.gson.Gson"%>

<%
	dicePokerDAO dao = dicePokerDAO.getInstance();

	String userId = request.getParameter("userId");
	dicePokerVO vo = dao.comSelect(userId);
	Gson gson = new Gson();
	String string = gson.toJson(vo);
	response.getWriter().append(string);
	System.out.print("COM È£Ãâ");
%>