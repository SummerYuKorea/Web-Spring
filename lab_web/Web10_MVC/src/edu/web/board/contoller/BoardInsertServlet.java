package edu.web.board.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.web.board.domain.BoardVO;
import edu.web.board.service.BoardService;
import edu.web.board.service.BoardSeviceImple;


@WebServlet(
		name = "boardInsert", 
		urlPatterns = { "/board-insert" })
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service;
       
  
    public BoardInsertServlet() {
        super();
        service= BoardSeviceImple.getInstance();
    }

	//board-main.jsp에서 이 서블릿을 get방식으로 부르기때문(따로 언급없으면 걍 get이지)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userid=(String)session.getAttribute("userid");
		if(userid==null){
			request.getRequestDispatcher("member-login").forward(request, response);
		}else{
			RequestDispatcher dispatcher =request.getRequestDispatcher("WEB-INF/board/board-insert-form.jsp");
			dispatcher.forward(request, response);
		}
	}


	//아까 doGet에서 이동했던 board-insert-form.jsp의 form안에서 다시 post방식으로 이 서블릿이 불림
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardInsertServlet.doPost() 호출");

		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String userid=request.getParameter("userid");
		BoardVO vo=new BoardVO(0,title,content,userid,null); //필요없는거는(나중에 안쓰면 되니까) 그냥 0, null으로 주는중
		
		//BoardService 객체의 create 메소드를 호출
		int result= service.create(vo);
		System.out.println("result:"+result);
		if(result==1){
			//DB insert 성공
			//게시글 목록(메인) 페이지로 redirect
			response.sendRedirect("board-main");	
		}
	}

}
