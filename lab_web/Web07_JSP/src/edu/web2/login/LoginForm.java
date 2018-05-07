package edu.web2.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginForm")
public class LoginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginForm() {
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forward란 일종의~ 코드합침!! 이야(아니야 코드 합침아니래)
		//서블릿에서 forward를 부르면 웹서버가!(정확히는?WAS가) 변환된 .class파일을 메모리에 올리고 거기에 _jspService를 호출해!!~
		//(jsp컴파일러에 의해 java파일(즉 서블릿(서블릿과 다른 구조()이지만 같은 개념))으로 변환됨)
		// jsp에서 jsp로 넘어갈때에도(jsp내에서 scriptlet이용하여//역시 forward나 redirect로) 마찬가지.
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("LoginCheck");//서블릿으로 넘어갈수도있네!!!
		dispatcher.forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
