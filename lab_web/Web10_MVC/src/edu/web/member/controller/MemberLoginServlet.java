package edu.web.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.web.member.domain.MemberVO;
import edu.web.member.service.MemberService;
import edu.web.member.service.MemberServiceImple;


@WebServlet(name = "memberLogin", urlPatterns = { "/member-login" })
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;
       
   
    public MemberLoginServlet() {
    	service=MemberServiceImple.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/member/member-login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid= request.getParameter("userid");
		String userpw= request.getParameter("userpw");
		MemberVO vo=service.select(userid, userpw);
		
		if(vo!=null){
			HttpSession session=request.getSession();
			session.setAttribute("userid", userid);
		
			response.sendRedirect("board-main");
			System.out.println("멤버로그인서블릿 내에 select vo로 받아옴");
		}
		
	}

}
