package edu.spring.ex03.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component  //spring에서 bean으로 관리하게하기위해
@Aspect
public class SecurityAspect {

	private static final Logger logger=LoggerFactory.getLogger(SecurityAspect.class);
	
	// pointcut을 지정하는 방법
	// 1. @Before, @After, @AfterReturning, @AfterThrowing... 어노테이션 안에서 지정  (LoggingAspect 클래스에서 씀)
	// 2. @Pointcut 어노테이션 안에서 지정 (SecurityAspect 클래스에서~ 지금 여기서~ 해볼껴)
			//-> 동일한 pointcut이 반복되는 것을 피할 수 있음
			//-> 한 번 지정한 pointcut을 여러 advice 메소드에서 참조
	
	@Pointcut("execution(* edu.spring.ex03.service.Customer*.update*(..))")
	public void updateAdvice(){}  //비어잇는함수처럼만들어서 이름을 지정
	
	@Around("updateAdvice()")
	public Object aroundAdvice(ProceedingJoinPoint jp){    //around:근처(앞 뒤 다처리할수있게)
		//jp의 메소드가 무엇을 리턴ㅇ할지 모르기 때문에 /모든 리턴타입을 받기위해 Object로 선언
		//프록시 객체가 일단 메소드릥 리턴값을 받아서, 그걸 다시 전달
		Object result=null;
		try {
			logger.info("=====메소드 호출 전=====");  //before
			
			//타겟의 포인트컷 메소드를 호출
			result=jp.proceed();  //ProceedingJoinPoint가 갖고 있는 메소드.  around에서는 proceeding- 으로 선언을 해줘야한대
			
			logger.info("=====메소드 리턴 후=====");  //afterReturning
		} catch (Throwable e) {
			logger.info("=====메소드 실행 중 예외 발생=====");  //afterThrowing
		}finally {
			logger.info("=====finally 실행=====");  //after
		}
		
		return result;
	}
}
