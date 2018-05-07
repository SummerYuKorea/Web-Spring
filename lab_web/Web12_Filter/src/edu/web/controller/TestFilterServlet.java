package edu.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "testFilter", urlPatterns = { "/test-filter" })
public class TestFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public TestFilterServlet() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestFilterServlet.doGet()호출! ");
		request.getRequestDispatcher("WEB-INF/main.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");//이걸 필터에서대신해보겠다
		String name=request.getParameter("username");
		HttpSession session=request.getSession();
		session.setAttribute("username", name);
		response.sendRedirect("test-filter"); //나한테(doGet)또 보내겠다
		
	}
	
	
	/*
	 *   <!-- Filter를 배포 관리자(Deployment descriptor)에서 설정  :방법2 (방법1은 annotation으로 하는것)-->
  <filter>
  	<filter-name>filter1</filter-name>
  	<filter-class>edu.web.filter.Test1Filter</filter-class>
  </filter>
   <filter>
  	<filter-name>filter2</filter-name>
  	<filter-class>edu.web.filter.Test2Filter</filter-class>
  </filter>
   <filter>
  	<filter-name>filter3</filter-name>
  	<filter-class>edu.web.filter.Test3Filter</filter-class>
  </filter>
  
  <filter-mapping>
  	<filter-name>filter1</filter-name>
  	<servlet-name>testFilter</servlet-name>
  </filter-mapping>
  <!-- 여기서는 mapping하는 순서대로 filter가 적용됨 // annotation으로는 순서를 지정할 수가 없지 -> web.xml사용을 권장 -->
  <filter-mapping>
  	<filter-name>filter2</filter-name>
  	<url-pattern>/test-filter</url-pattern> <!-- test-filter라는 url이 사실은 바로 위에testFilter서블릿이랑 똑같은거임 -->
  </filter-mapping>
  <filter-mapping>
  	<filter-name>filter3</filter-name>
  	<url-pattern>/*</url-pattern><!-- context root다음에 들어오는 모든 url-pattern에 대해 mapping하겠다 -->
  </filter-mapping>
  <!-- testFilter라는 서블릿 실행했을 떄 필터의 적용순서를 보장~ 
  
  필터2의 doFilter 호출: chain.doFilter호출전
  필터3의 doFilter 호출: chain.doFilter호출전
  필터1의 doFilter 호출: chain.doFilter호출전
 TestFilterServlet.doGet()호출! 
 필터1의 doFilter 호출: chain.doFilter호출 후~~
 필터3의 doFilter 호출: chain.doFilter호출 후~~
 필터2의 doFilter 호출: chain.doFilter호출 후~~
 
 ->일단 먼저적을수록 먼저적용되겠지만 url-pattern을 줬을 때는 걔가 먼저~
 ->1) url-pattern이 servlet-name보다 우선
   2) web.xml에 mapping된 순서를 따름
   -->
	 * 
	 * */

}
