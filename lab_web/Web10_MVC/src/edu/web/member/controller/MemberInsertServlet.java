package edu.web.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.member.domain.MemberVO;
import edu.web.member.service.MemberService;
import edu.web.member.service.MemberServiceImple;


@WebServlet(name = "memberInsert", urlPatterns = { "/member-insert" })
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;
   
    public MemberInsertServlet() {
		service=MemberServiceImple.getInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/member/member-insert.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		String userpw=request.getParameter("userpw");
		String email=request.getParameter("email");
		MemberVO vo=new MemberVO(userid, userpw, email, "Y");
		service.insert(vo);
		
		System.out.println("회원가입 완료");
		
		// 위에 주소 바뀌면 좋으ㅁ니까 redirect로 보내보자
		response.sendRedirect("member-login?userid="+userid);
	}

}
