package edu.spring.ex04.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor2 extends HandlerInterceptorAdapter {
	
	private static final Logger logger= LoggerFactory.getLogger(SampleInterceptor2.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("=========preHandle 호출");
		
		HandlerMethod handlerMethod =(HandlerMethod) handler;
		Method method= handlerMethod.getMethod();
		logger.info("Bean : "+handlerMethod.getBean());
		logger.info("method : "+method.getName());
		
		return true; //preHandle에서 리턴값의 의미?
		
		//true면 아까랑똑같(pre->메소드실행->post->afterCompletino) //원래 실행하려고 했던 콘트롤러 메소드를 실행
		//false 면 preHandle까지 실행되고 끝 //콘트럴러 메소드를 실행하지 않음
		// 원래 실행하려고 했던 콘트롤러 메소드가 실행되지 않게 할수 있어!
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("=========postHandle 호출");
		
		String data=(String)(modelAndView.getModel().get("data"));  //모델에서 get하면 Object를 리턴~
		logger.info("data: "+data);
		if(data==null){
			HttpSession session=request.getSession();
			session.setAttribute("data", "DUMMY DATA");   //이렇게하면 이제 test1으로 이동했을때 JSP에 뜨지!
		}
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("=========afterCompletion 호출");
		super.afterCompletion(request, response, handler, ex);
	}
}
