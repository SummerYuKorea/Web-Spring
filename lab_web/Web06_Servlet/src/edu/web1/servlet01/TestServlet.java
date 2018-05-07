package edu.web1.servlet01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(name = "testServlet", urlPatterns = { "/testServletUrlMapping","/hello" })
	//이름 & urlPatterns(문자열배열) 지정된거 확인  //hello로 주소 검색해도 나오도록 지정  //
	//annotation만(@)바꿨을때는 컴파일다시안해줌.재시작해야한대(재시작안해도되는데?)
	// Annotation방식으로 Servlet URL mapping 설정-> Servlet3.0버전 이후부터 적용 (Tomcat8.0은 Servlet3.0을 사용중)
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");	//이거써줘도 charset이없어서 브라우져가 인코딩을 뭘로해야하는지 감을못잡~
		response.getWriter().append("<h1>This is TestServlet</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
