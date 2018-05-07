<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="dicePoker.dicePokerDAO"%>
<%@page import="dicePoker.dicePokerVO"%>
<%@page import="com.google.gson.Gson"%>

<%
	dicePokerDAO dao = dicePokerDAO.getInstance();

	String userId = request.getParameter("userId");
	String passWd = request.getParameter("passWd");
	dicePokerVO vo = dao.select(userId, passWd);
	Gson gson = new Gson();
	/* vo.setUserId("summer");
	vo.setPassWd("1234"); */
	String string = gson.toJson(vo);
	System.out.println("À×:"+string+"lo?"+vo.getUserId());
	response.getWriter().append(string);
%>