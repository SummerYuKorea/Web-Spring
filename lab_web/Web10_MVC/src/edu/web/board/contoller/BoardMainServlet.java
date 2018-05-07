package edu.web.board.contoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.board.domain.BoardVO;
import edu.web.board.service.BoardSeviceImple;

@WebServlet(
		name = "boardMain", 
		urlPatterns = { "/board-main" })
public class BoardMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//Controller는 Service객체의 메소드를 사용할거야(사용하는 주체가 인스턴스 생성한다)
	private BoardSeviceImple service;
	
    public BoardMainServlet() {
    	//BoardService 인스턴스를 구함
        service=BoardSeviceImple.getInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB에서 게시글 목록을 읽어와서(select) JSP에게 전달
		List<BoardVO> list=service.read();
		System.out.println("BoardMainServlet(controller)의 doGet실행중: 받은 listSize="+list.size());
		
		//request를 통해 JSP에 전달해주자
		request.setAttribute("boardList", list);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/board/board-main.jsp");
		dispatcher.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("loginStatus", "login");//post로들어오면(로그인창에서 post로넘겼으므로) 로그인 상태란 얘기
		doGet(request, response);
	}

}
