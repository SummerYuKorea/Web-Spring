package edu.spring.ex04.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.spring.ex04.controller.MemberController;
import edu.spring.ex04.domain.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger=LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("===postHandle호출");
		
		//모델 객체의 login_result 속성을 확인 (아까 컨트롤러의 메소드에서 넣은)
		// null이아니면 로그인 성공-> Session객체에 login_id 속성 추가
		// null이면 메인페이지로 이동
		MemberVO vo = (MemberVO)(modelAndView.getModel().get("login_result"));
		
		if(vo!=null){
			HttpSession session=request.getSession();
			session.setAttribute("login_id", vo.getUserid());
			response.sendRedirect("/ex04");
			
		}else{
			logger.info("여기~~~~~~~~~");
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

}
