package edu.spring.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//Spring Framework한테 알려줌
public class SampleController3 {

	private static final Logger logger= LoggerFactory.getLogger(SampleController3.class); 
	// 클래스 매개변수 넣음으로서 무슨 클래스에서 로그를 출력하는지 로그에 클래스 이름도 찍어주게됨
	
	@RequestMapping(value="/test4")//하나의 메소드가 여러개 url을 처리할 수는 있지만 하나의 url이 여러개 메소드에 선언될 순 없어(무슨 메소드를 호출할지 찾을수가 x)
	//public String test4(@ModelAttribute(name="username") String username){  // 또 name이 안되네?
	public String test4(@ModelAttribute("username") String username){
			//ModelAttribute annotation을 선언하면 username을 Model객체에 addAttribute까지 해주는 게 됨
		
		logger.info("test4() 호출");
		
		return "param-test";
	}
	
	@RequestMapping(value="test5")
	public String test5(@ModelAttribute("username") String username,
									@ModelAttribute("age") int age){//Dispatcher Servlet 이라는 클래스가 이 메소드 불러야 되므로 public!!으로 만들것
	
		logger.info("test5() 호출");
		
		return "param-test";
	}
	
}
