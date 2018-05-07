package edu.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//ServletRequest/Response
		//	|_ HttpServletRequest/Response
		HttpSession session=((HttpServletRequest)request).getSession();
		if(session.getAttribute("username")!=null){
			chain.doFilter(request, response);
		}else{
			((HttpServletResponse)response).sendRedirect("login");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
