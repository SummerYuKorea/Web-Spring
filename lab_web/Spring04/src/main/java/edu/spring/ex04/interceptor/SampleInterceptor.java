package edu.spring.ex04.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter {
	//인터셉트는 Spring에서 거의 유일하게 다른 특정한 클래스를 상속받아 만드는 클래스 (원래 Spring은 POJO 클래스가 특징이자나~)
	
	private static final Logger logger= LoggerFactory.getLogger(SampleInterceptor.class);
	
	
	// 요청(reqeust)에 해당하는 콘트롤러 메소드가 동작하기 전에 요청을 가로채서 해야할 기능들을 수행 (2번위치)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info("=========preHandle 호출");
		return super.preHandle(request, response, handler);
	}
	
	// 콘트롤러 메소드가 수행된 이후에,
	// DispatcherServlet이 View(JSP)를 처리하기 전에 (7번 위치)
	// 해야할 기능들을 수행
	//  ->그래서 아직 모델객체 가로채기 가능. 수정 or 추가 등 가능ㅇ
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		logger.info("=========postHandle 호출");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	// Front Controller가 JSP이용해서 View까지 다 만들어낸 이후! 
	// DispatcherServlet에 의해서 화면처리가 끝난 후에
	// 해야할 기능들을 작성
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		logger.info("=========afterCompletion 호출");
		super.afterCompletion(request, response, handler, ex);
	}

}
