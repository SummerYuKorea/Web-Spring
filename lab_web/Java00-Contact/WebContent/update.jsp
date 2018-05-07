<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="dicePoker.dicePokerDAO"%>

<%
	dicePokerDAO dao = dicePokerDAO.getInstance();

	String title = request.getParameter("title");
	int win = Integer.parseInt(request.getParameter("win"));
	int lose = Integer.parseInt(request.getParameter("lose"));
	int gold = Integer.parseInt(request.getParameter("gold"));
	int totalGame = Integer.parseInt(request.getParameter("totalGame"));
	int gameOn = Integer.parseInt(request.getParameter("gameOn"));
	int diceSkin = Integer.parseInt(request.getParameter("diceSkin"));
	int backSkin = Integer.parseInt(request.getParameter("backSkin"));
	int voice = Integer.parseInt(request.getParameter("voice"));
	String userId = request.getParameter("userId");
	
	dao.update(title, win, lose, gold, totalGame,
			gameOn, diceSkin, backSkin, voice, userId);
	System.out.print("업데이트 실행");
%>