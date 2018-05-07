package edu.spring.ex02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.ex02.service.MemberService;
import edu.spring.ex02.domain.MemberVO;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void selectMemberList(Model model){//관리자로 로그인하면 회원리스트 볼 수 있게 
		//나중에 관리자 if
		List<MemberVO> list=service.select();
		model.addAttribute("memberList",list);
	}

	@RequestMapping(value="/login", method=RequestMethod.GET) //로그인하겠다고 들어옴
	public void loginGET(){
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST) //아디비번입력후
	public String loginPOST(MemberVO vo){
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.GET)// 회원가입하겠따고 들어옴
	public void insertGET(){
		
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)// 정보입력후 회원가입! 클릭했을때
	public String insertPOST(MemberVO vo){
		//아이디확인하자 Ajax로
		
		service.insert(vo);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)//내정보들어옴
	public void detail(String userid, Model model){
		model.addAttribute("vo",service.select(userid));
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET) //수정하겠다고할때
	public void updateGET(MemberVO vo, Model model){
		model.addAttribute("vo",vo);
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST) //수정하고 나서 완료
	public String updatePOST(MemberVO vo){
		service.update(vo);
		return "redirect:list";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(String userid){ //이게 delete인거 같지만 사실은 active를 N로 update할거야(계정 비활성화)
		service.delete(userid);
		return "redirect:  list";
		
	}
}
