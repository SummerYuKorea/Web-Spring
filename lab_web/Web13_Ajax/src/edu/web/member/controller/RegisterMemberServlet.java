package edu.web.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.member.domain.MemberVO;
import edu.web.member.service.MemberServiceImple;

@WebServlet(name = "registerMember", urlPatterns = { "/register-member" })
public class RegisterMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberServiceImple service;
       
    public RegisterMemberServlet() {
    	
    	service=MemberServiceImple.getInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/register-member.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //얘는 이거 안쓰면 안되지 //ajax의 post와는 달리
		String id=request.getParameter("userid");
		String pw=request.getParameter("userpw");
		String email =request.getParameter("email");
		MemberVO vo=new MemberVO(id, pw, email, null);
		int result=service.insert(vo);
		
		System.out.println("인서트 결과: "+result);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		if(result==1){
			out.write("<h1>회원가입 성공</h1>");  //jsp파일로 넘기는 대신 이렇게 하는중(좋은 코드는 아니라고 함)
		}else{
			out.write("<h1>회원가입 실패</h1>");
		}
		
		
	}

}
