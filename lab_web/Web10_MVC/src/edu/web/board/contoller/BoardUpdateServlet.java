package edu.web.board.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.board.domain.BoardVO;
import edu.web.board.service.BoardService;
import edu.web.board.service.BoardSeviceImple;

@WebServlet(
		name = "boardUpdate", 
		urlPatterns = { "/board-update" }
)
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService instance;
       
 
    public BoardUpdateServlet() {
    	instance= BoardSeviceImple.getInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bno= Integer.parseInt(request.getParameter("bno"));
		BoardVO  vo = instance.read(bno);
		if(vo!=null){
			request.setAttribute("boardVO", vo);
			request.getRequestDispatcher("WEB-INF/board/board-update.jsp").forward(request, response);;
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int bno=Integer.parseInt(request.getParameter("bno"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String userid=request.getParameter("userid");
		
		BoardVO vo=new BoardVO(bno,title,content,userid,null); //bno 업데이트에 where시 넣어줘야되므로 필요함
		int result= instance.update(vo);
		
		if(result==1){
			//DB 수정 성공
			response.sendRedirect("board-detail?bno="+bno);
		}
	}

}
