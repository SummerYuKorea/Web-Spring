package edu.spring.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {

	private static final Logger logger= LoggerFactory.getLogger(SampleController2.class);
	
	@RequestMapping(value="/test1")
	public String test1(Model model, String username){  //이 매개변수는 ( username) queryString으로 넘겨주면 넘어감
		logger.info("test1() 호출 :  username="+username);
		model.addAttribute("username", username);   //단지 모델이라는 클래스에 줬음
		//		스프링 프레임웤이 model이라는 클래스 만들어서 그안에 넣은 거 전달해 줌
		return "param-test";
	}
	
	@RequestMapping(value="/test2")
	public String test2(Model model, int age){  //request parameter의 값들은 무조건 string이엇지 그래서 int로 바꾸고 자시고 해야했지만 얜 그냥 int~
		logger.info("test2() 호출 :  age= "+age);
		model.addAttribute("age",age);
		return "param-test";
	}
	
	@RequestMapping(value="/test3")
	public String test3(Model model, String username, int age){ 
			//controller에서 JSP로 정보를 넘겨줘야해!-> Model 클래스를 이용 
			// requestParameter를 통해(query String) 정보를 받아오고 싶어! -> username, age를 매개변수에 선언
	//	model.addAttribute("username",username);
		//model.addAttribute("age",age);
		
		logger.info("test3() 호출 :  username="+username+"  age="+age);
		return "param-test";
	}
}//end class SampleController2
