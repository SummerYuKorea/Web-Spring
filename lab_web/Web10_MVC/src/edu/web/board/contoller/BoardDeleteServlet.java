package edu.web.board.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.board.service.BoardService;
import edu.web.board.service.BoardSeviceImple;


@WebServlet(name = "boardDelete", urlPatterns = { "/board-delete" })
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private BoardService instance;

    public BoardDeleteServlet() {
        instance=BoardSeviceImple.getInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno=Integer.parseInt(request.getParameter("bno"));
		if(instance.delete(bno)==1){//삭제성공
			response.sendRedirect("board-main");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
