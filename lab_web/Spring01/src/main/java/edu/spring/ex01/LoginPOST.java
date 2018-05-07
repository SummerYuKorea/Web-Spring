package edu.spring.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginPOST { //annotation은 xml에서의 환경설정 역할을 대신해줌 
	
	@RequestMapping(value="/login") //
	public String showInfo(){
		return "login-form";
	}

	@RequestMapping(value="/loginPOST")
	public String showInfo(String username, String userpw){ //Model클래스 아예 안쓰고 이렇게 해서 ${param.~}로 받기
																										//단 attribute에 안넣으면 setCharacterEncoding이 자동으로 안되는듯
		return "login-form";
	}
	
}
