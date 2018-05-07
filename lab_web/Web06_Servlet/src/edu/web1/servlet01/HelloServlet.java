package edu.web1.servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//C:\Study\lab-web\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Web06_Servlet\WEB-INF\classes\edu\web\servlet01
//안에 서블릿클래스가 컴파일된 파일이 들어있음

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet") //
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {  	//나중에 웹애플리케이션서버(WAS)가 이 생성자를 부르게 될 것
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //주소칸에 주소치고엔터치면 doGet호출되는 것!
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath()); //Served at: /web06 ->web06에서 서비스되고있다.
		
		//response.getWriter().append("잉~");
		//이 서블릿이 response를 보내주는것.
		//getWriter는 IOStream중 하나//Writer객체를 가지고 오는것. 그 객체에 문자열을 append하겠다 쌓인 문자열들이 네트웤선을 따라서 전달되는것
		
		
		//클라이언트(브라우져)에게 응답을 보내는 문자열이 어떤 인코딩 타입을 사용할지 설정.
		response.setCharacterEncoding("UTF-8");
		
		//응답을 쓰기(write) 위한 Writer객체(Output Stream)를 얻어옴
		PrintWriter writer =response.getWriter();
		
		//Writer 객체를 사용해서 응답 내용을 작성
		writer.append("<!doctype html>").append("<html>").append("<head>").append("<meta charset='utf-8'/>")
				.append("<title>Servlet</title>").append("</head>").append("<body>")
				.append("<h1>한결이만세~</h1>")
				.append("</body>").append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
