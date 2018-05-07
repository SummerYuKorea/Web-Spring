package edu.web2.login;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginTest") //URL mapping 이름
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login doGet() 호출");
		
		
		// GET 방식에서 요청 파라미터는// URL 주소의 query string에 포함되어 있음.(포함될때 %어쩌고 적혀있으면 UTF-8코드값)
		// http://localhost:8181/web06/loginTest?id=summer&passwd=ehehsi
		// http : 프로토콜
		// localhost : 서버 주소(도메인 이름)
		// 8181 : 포트 번호
		// web06 : context root(서버에서 파일을 찾아갈 수 있는 경로)
		// loginTest : URL mapping
		// ?id=summer&passwd=ehehsi : 쿼리 스트링 Query String
		
		// 요청 파라미터(request parameter)의 값을 읽어옴
		String id=request.getParameter("id");
		String passwd=request.getParameter("passwd");
		
		response.setCharacterEncoding("UTF-8"); //한글을 사용할 수도 있으므로
		
		
		//Writer 객체를 얻어오자
		Writer writer= response.getWriter();
		//writer.append("되나보자"); //여기 앞에다주면 얘가 밑에 html코드를 못읽어 
		writer.append("<!DOCTYPE html>").append("<html>").append("<head><meta charset='utf-8'/></head>")
				.append("<body>").append("<h1>로그인 결과</h1>").append("USER ID는 "+id+"<br/>USER PASSWD은 "+passwd +"이다~")
				.append("</body>").append("</html>");  //이거 쓴 결과 개발자도구->네트워크에서 Name에 있는거 클릭하면 볼 수 있네?
		
		//writer.append("되나보자"); //근데 밑에다 쓰면 이미 html잘끝나서 그런가 그냥 무시함
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login doPost() 호출");
		
		//POST: requestParameter가 request 바디안에 포함이 되어 있기 때문에 인코딩타입을 지정해야 열어볼때 한글도 알아볼 수 있지
		//GET: URL에 데이터가 실려서 넘어가는데 URL을 인코딩하는 방식은 UTF-8밖에 없기 때문에 굳이 UTF-8 지정 안해도 됨?
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);//이때 넘어가는 데이터는 query String이 아니라 Form Data라고 부르네(개발자도구->네트워크->header에서 확인가능)
								//그래서 post방식으로 보내도 패킷만 가로채면 내용 다 볼 수 있는거지// 그래서 애초에 암호화 해서 보내야해
								//그리고 content Type이라는 게 있음.
								//네트워크에서 패킷의 규격을 정해놓음 헤더/바디  //form data는 바디에 들어있대
	}

}
