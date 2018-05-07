package edu.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Test2Filter
 */
//@WebFilter("/Test2Filter")
public class Test2Filter implements Filter {

    public Test2Filter() {
       
    }

	
	public void destroy() {
		System.out.println("필터2 destroy");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("필터2의 doFilter 호출: chain.doFilter호출전");
		chain.doFilter(request, response);
		System.out.println("필터2의 doFilter 호출: chain.doFilter호출 후~~");
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("필터2의 init 호출");
	}

}
