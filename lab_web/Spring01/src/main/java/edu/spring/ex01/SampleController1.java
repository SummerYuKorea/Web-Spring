package edu.spring.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//POJO: Plain Old Java Object  (강력한 기능 발휘~)

@Controller  //Handler Mapping이 얘가 Controller인 걸 찾아줌 how?
						//1. web.xml에 <annotation-driven/>을 설정해놨기때문 
						//2. servlet.xml에 component-scan 에 설정되어있는 base-package에 설정해놓은 패키지("edu.spring.ex01") 내에서 찾게됨
//by SSAM
//servlet-context.xml 파일에서
//component-scanning의 대상으로 만들어 주는 어노테이션
//@Component 어노테이션을 사용해도 됨
public class SampleController1 {

	// 스프링 프레임워크에서 로그를 사용하기 위한 객체
	private static final Logger logger //org.slf4j의 것을 사용해야함. sysout 대신쓰는애.
					=LoggerFactory.getLogger(SampleController1.class);
	
	@RequestMapping(
			value="/sample1", 
			method=RequestMethod.GET)
	//@RequestMapping: 콘트롤러의 URL 매핑과 메소드(GET/POST)를 설정
	// value: URL 매핑
	// method: 요청 방식( GET/POST)
	// method 속성을 생략하면 GET/POST 모두 처리 가능
	public String sample1(){ //메소드 이름, 매개변수 다 노상관. annotation설정만 잘해주면됨~
		logger.info("sample1() 호출"); 
		return "sample1";
		//controller method에서 return값의 의미?
				//ViewResolver에게 실제 View를 결정하도록(찾도록) 요청 (servlet-context.xml 가서 접두사 접미사 붙여서~)
				// return 타입이 void인 경우는 URL 매핑을 통해서 View를 찾음
	}//sample1()
	
	
	//@RequestMapping(name="/sample2")  //name도 됨 (value, name or 생략도됨("/sample2")일케) 
	//워크스페이스 다시 하니까 name 서든리 안되기??
	@RequestMapping("/sample2")
	public void sample2(){
		logger.info("sample2()호출");
	}//sample2()
	
	@RequestMapping(value="/sample3", method=RequestMethod.GET)
	public void sample3(){
		logger.info("sample3()호출");
	}
}
