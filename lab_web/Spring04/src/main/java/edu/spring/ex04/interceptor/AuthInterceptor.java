package edu.spring.ex04.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class AuthInterceptor 
	extends HandlerInterceptorAdapter {

	private static final Logger logger =
			LoggerFactory.getLogger(AuthInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("===== preHandle 호출");
		// 로그인 상태: register 콘트롤러 메소드 실행
		// 로그인 안 된 상태: 로그인 양식으로 redirect, 콘트롤러 메소드는 실행하지 않음
		
		HttpSession session = request.getSession();
		String userId = (String)
				session.getAttribute("login_id");
		if (userId != null) { // 로그인 상태
			logger.info("로그인 상태 -> register() 실행");
			return true; // 콘트롤러 메소드 실행
		} else { // 로그인 안 된 상태
			logger.info("로그인 안 된 상태 -> loginGet() 실행");
			
			// 로그인 성공 후에 redirect될 페이지를 세션에 저장
			saveDestination(request);
			response.sendRedirect("../member/login");
			return false; // 콘트롤러를 실행하지 않음
		}

	} // end preHandle()
	
	private void saveDestination(HttpServletRequest req) {
		logger.info("saveDestination() 호출");
		
		// 전체 요청 주소에서 쿼리 스트링을 제외한 부분 
		String uri = req.getRequestURI();
		logger.info("요청 URI: " + uri);
		
		// 전체 요청 주소에서 쿼리 스트링만 추출
		String queryString = req.getQueryString();
		logger.info("쿼리 스트링: " + queryString);
		String url = "";
		if (queryString == null) {
			url = uri;
		} else {
			url = uri + "?" + queryString;
		}
		
		req.getSession()
			.setAttribute("dest", url);
		
	} // end saveDestination()
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
	
} // end class AuthInterceptor


