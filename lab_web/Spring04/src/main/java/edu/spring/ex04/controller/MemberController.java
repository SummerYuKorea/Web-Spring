package edu.spring.ex04.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.ex04.domain.MemberVO;
import edu.spring.ex04.service.MemberService;

@Controller
@RequestMapping(value="member")
public class MemberController {
	
	private static final Logger logger=LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="login-post", method=RequestMethod.POST)
	public String loginPost(MemberVO vo, Model model){
		logger.info("이것봐~-->>>"+vo.getUserid());
		MemberVO user=service.login(vo);
		model.addAttribute("login_result", user);
		
		return "test";
	}
	
	@RequestMapping(value = "/logout",
			method = RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		logger.info("logout() 호출");
		
		HttpSession session = req.getSession();
		session.removeAttribute("login_id");
		session.invalidate();
		
		return "redirect:/member/login";
	}
	
	@RequestMapping(value = "/login",
			method = RequestMethod.GET)
	public void loginGet(String url, Model model) {
		logger.info("loginGet() 호출");
		logger.info("url: " + url);
		model.addAttribute("targetUrl", url);
	}

}
