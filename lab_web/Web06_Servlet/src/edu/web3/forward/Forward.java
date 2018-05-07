package edu.web3.forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/forward")
public class Forward extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Forward() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("forward doGet() 호출");
		response.setCharacterEncoding("UTF-8");//이건 브라우져에 utf인코딩 형식으로 넘기겠다는것
		//이걸 왜해줘야 하냐면 나중에 forward로 페이지 이동했을 때 거기의 내용들이 사실은 Servlet으로 넘어와서 response에 기록되는거야.
		// 여기에 쫙 귀찮게 response 적는거랑 똑같은 거란 거지. 그러니까 그 내용들이 한글도 잘 출력하려면 encoding 넣어줘야
		PrintWriter writer=response.getWriter();
		writer.append("서브드 앳: ").append(request.getContextPath());
			//이거 이런식으로 적으면(태그로 html형식지키지않은) 
			//크롬이 auto detecting 하는 와중에서(자동으로 브라우져에서 출력할 인코딩형식을 찾아서 처리하는것)	
			//제대로 못찾네(게다가 크롬설정에 인코딩메뉴가 없어져서 강제로 못바꿈)
			// 앞으로 이런식으로 쓸 일은 없으니까 뭐 그런듯.
		
		// forward 방식으로 페이지를 이동할 때는
		// RequestDispatcher 인터페이스의 forward(request, response) 메소드를 사용
		//  	 dispatcher:운행관리원 dispatch:전송하다,보내다,신속히해치우다
		RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
		
		//redirect 방식의 페이지 이동을 할 때는  
		// response 클래스의 sendRedirect()메소드 호출
		//		redirect:다시보내다
		//response.sendRedirect("index.jsp"); //이걸로 페이지 이동하면 페이지 주소가 바뀌면서 id는 (request를 못넘겨 받으니까) 널으로 출력한다
				//얘는 매개변수에 구글주소도 줄수있어 
	}
	//Servlet은 UI 짜기가 너무 빡치자낭~ 그래서 페이지이동하는거야 JSP나 HTML으로. forward/redirect
	
	//웹에서 페이지 이동 방식:
	// 1. forward: URL 주소 유지. request/response 객체 유지
	//				같은 웹 서버 내에 있는 파일들로만 이동이 가능~
	// 2. redirect: URL 주소 바뀜. request/response 객체 소멸!! 왜씀?!
	//				같은서버/다른서버에 있는 페이지 모두 이동 가능
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
