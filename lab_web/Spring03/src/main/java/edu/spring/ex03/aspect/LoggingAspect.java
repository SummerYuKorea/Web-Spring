package edu.spring.ex03.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import edu.spring.ex03.service.CustomerServiceImple;

@Component  //Proxy객체에 주입(inject)하기 위해서
@Aspect // Aspect =Advice(해야할 일) + Pointcut(이 일어나는 곳)
public class LoggingAspect {
	
	private static final Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
	//junit의 before말고
	@Before("execution(* edu.spring.ex03.service.CustomerServiceImple.*Customer(..))")  // 패키지.클래스.메소드 //포인트 컷을 적어준것이래
																					//이 메소드가 불리면 proxy가 그걸 가로채서 @before을 먼저 실행하겠ㄷ다는 얘기(좌측에 화살표 아이콘! 거기로 들어가겠다!는표시~)
																					//method요소?: 리턴타입, 매개변수! 그거 표시한거임 //모든 리턴타입에 대해. 모든 매개변수 형태에 대해.
																					//메소드 이름 *Customer(..) 과 같은 식으로 쓸 수도 있음 //지금은 createCustomer(..)
	public void beforeAdvice(JoinPoint jp){
		logger.info("=====beforeAdvice=====");
		
		logger.info("target: " + jp.getTarget() );
		//target: edu.spring.ex03.service.CustomerServiceImple@44a2b17b    이라고 뜸
		
		logger.info("signature: "+jp.getSignature());
		//signature: int edu.spring.ex03.service.CustomerService.createCustomer()  라고 뜸~
		
		// JoinPoint? 
		// 우리가 만든 Aspect가 weaving이 되는 join point에 대한 정보
		// target, targer안에 메소드 등등
		// 매개변수로 선언만하면 사용가능
	}
	
	@After("execution(* edu.spring.ex03.service.CustomerServiceImple.createCustomer(..))")
	public void afterAdvice(){
		logger.info("=====afterAdvice=====");
	}
	
	@AfterReturning("execution(* edu.spring.ex03.service.CustomerServiceImple.createCustomer(..))")
	public void afterReturningAdvice(){
		logger.info("=====afterReturningAdvice=====");
	}
	
	@AfterThrowing("execution(* edu.spring.ex03.service.CustomerServiceImple.createCustomer(..))")
	//afterThrowingTargetMethod() 충고는 targetMethod()로 정의된 포인트컷에서 예외가 발생한 후에 수행된다. 
	//targetMethod() 포인트컷에서 발생된 예외는 exception 변수에 저장되어 전달된다. 
	public void afterThrowingAdvice(){
		logger.info("=====afterThrowingAdvice=====");
	}
	
}
