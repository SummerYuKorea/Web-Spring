package edu.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//@WebFilter(filterName = "filter1", servletNames = { "testFilter" }) //testFilter라는 서블릿을 실행하기 전에 filter를 끼우겠다 하는 의미
public class Test1Filter implements Filter {

    
    public Test1Filter() {
    }

	public void destroy() {  //필터가 소멸될 때
		System.out.println("필터1의 destroy 호출");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("필터1의 doFilter 호출: chain.doFilter호출전");
		chain.doFilter(request, response); //-> 여기서 servlet으로 점프하는것!(서블릿의 doGet이 불림) //실행이 일반적인 자바코드와 달라
		//이췌인은 filter의 연결.chain을말함. 이걸하면 다음필터의 doFilter를 호출하겠다는 뜻
		//만약 내가 마지막 filter면, chain의 끝이면 서블릿이 실행됨.
		System.out.println("필터1의 doFilter 호출: chain.doFilter호출 후~~");
	}

	public void init(FilterConfig fConfig) throws ServletException { //필터를 초기화 할 때
		System.out.println("필터1의 init 호출");
		// 서버가 시작될때!!
		// 클라이언트로부터 요청(request)가 들어오기도 전에 설치됨~
		// 그래야 나중에 request에서 먼지 들어올 때 걸러내겠지 필터가~
		
	}

}
