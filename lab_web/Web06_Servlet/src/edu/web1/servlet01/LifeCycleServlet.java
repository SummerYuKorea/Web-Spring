package edu.web1.servlet01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet(
		urlPatterns={"/LifeCycleServlet"},
		loadOnStartup=1
		)
// Servlet 설정 프로퍼티중 loadOnStartup
// -> 서버가 실행될 때 서블릿 인스턴스를 메모리에 로드하는 우선 순위를 설정(서블릿들 중에. 인듯)  
//	     숫자가 작을 수록 우선 순위가 높음.
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출");
		response.getWriter().append("<h1>Life Cycle</h1>");//이걸 추가로 적고 ctrl+s(저장)했더니 destroy됨//그 후 요청이 들어오면 다시 init->doGet
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("doPost() 호출");
	}
	
	
	//Servlet Life Cycle 메소드 
	
	@Override
	public void init() throws ServletException {  //Servlet이 처음에 initialize될 때(초기화 작업)
											//(Servlet의 생성자가 호출된 다음에 인스턴스의 초기화 작업을 위해 여러가지 일들을 하는(파라미터초기화, 디비연결..))
		System.out.println("init() 호출");
		
		//init이 하는 일이 많으면 최초 한 번은 실행 시간이 오래걸릴 수 있음
		//그래서 요청이 없어도 미리 메모리에 올려놔서 최초실행도 빠른시간안에 되도록 할 수 있음->loadOnStartUp
		//	->저거 설정하면 우선 순위에 따라서 서버가 실행될 때 init() 메소드가 호출됨.
	}
		
	@Override
	public void destroy() {		//Servlet이 종료될 때 호출되는 생명 주기 함수
		System.out.println("destroy() 호출");
	}
	
	//서블릿이 한 번 실행되면(메모리에 올라가면). 계속메모리에 남아있음. 그 서버 한 녀석이 다른 요청들(해당프로젝트의 다른 servlet실행시켜도)도 모두 실행시킴. destroy x
	//서버가 종료가 되거나, 서블릿클래스가 바뀌어서 클래스를 교체(다시컴파일)할 때가 아니면 destroy가 불리지 않음

}
