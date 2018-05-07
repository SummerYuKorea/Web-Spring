package edu.web.board.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.board.service.BoardSeviceImple;


@WebServlet("/board-detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardSeviceImple instance;
 
    public BoardDetailServlet() {
       instance=BoardSeviceImple.getInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		int bno=Integer.parseInt(request.getParameter("bno"));
		request.setAttribute("boardVO", instance.read(bno));
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/board/board-detail.jsp");
		
		//response.setCharacterEncoding("UTF-8");
		dispatcher.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
