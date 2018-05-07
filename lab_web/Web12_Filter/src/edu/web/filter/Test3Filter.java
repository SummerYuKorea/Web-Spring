package edu.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/Test3Filter")
public class Test3Filter implements Filter {

    public Test3Filter() {
    }

	public void destroy() {
		System.out.println("필터3의 destroy 호출");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//이필터를 거치는 모든 request에 설정하자
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("필터3의 doFilter 호출: chain.doFilter호출전");
		chain.doFilter(request, response);
		System.out.println("필터3의 doFilter 호출: chain.doFilter호출 후~~");
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("필터3의 init 호출");
	}

}
